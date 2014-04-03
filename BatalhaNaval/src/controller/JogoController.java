package controller;

import model.Embarcacao;
import model.Tabuleiro;
import model.UnidadeTabuleiro;
import model.embarcacoes.Destroyer;
import model.embarcacoes.Fragata;
import model.embarcacoes.PortaAvioes;
import model.embarcacoes.Submarino;
import model.embarcacoes.Torpedeiro;
import view.ComplexTabuleiroView;
import view.InteracaoUsuarioView;
import view.MensageiroView;
import view.SimpleTabuleiroView;
import view.TabuleiroView;

public class JogoController
{
	private static final int DIMENSOES_TABULEIRO = 6;
	private static final int PONTUACAO_POR_DISPARO = -1;
	private static final int PONTUACAO_POR_ALVO_ATINGIDO = 3;
	private static final int PONTUACAO_POR_ALVO_DESTRUIDO = 5;
	
	private Tabuleiro tabuleiro;
	private TabuleiroView tabuleiroView;
	private int pontuacao;
	
	public JogoController()
	{
		this.tabuleiro = new Tabuleiro(DIMENSOES_TABULEIRO, DIMENSOES_TABULEIRO);
		this.tabuleiro.addEmbarcacaoPorSorteio(new PortaAvioes());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Destroyer());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Destroyer());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Fragata());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Fragata());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Torpedeiro());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Torpedeiro());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Torpedeiro());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		this.tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		this.tabuleiro.finalizarMontagemTabuleiro();
		this.pontuacao = 15;
		this.tabuleiroView = null;
	}
	
	private void selecionarView()
	{
		String entrada;
		do {
			entrada = InteracaoUsuarioView.solicitarEntrada("Exibir grade no tabuleiro (1-Nao | 2-Sim): ");
		} while (!entrada.equals("1") && !entrada.equals("2"));
		if (entrada.equals("1")) {
			this.tabuleiroView = new SimpleTabuleiroView();
		} else {
			this.tabuleiroView = new ComplexTabuleiroView();
		}
	}
	
	public void iniciar()
	{
		selecionarView();
		
		Embarcacao embarcacao = null;
		
		tabuleiroView.print(this.tabuleiro);
		MensageiroView.imprimeStatusJogo(this.pontuacao, tabuleiro.getQtdeEmbarcacoesRestantes());
		
		while (this.pontuacao > 0 && tabuleiro.getQtdeEmbarcacoesRestantes() > 0) {
			embarcacao = disparar(InteracaoUsuarioView.solicitarEntrada("Alvo: "));
			
			tabuleiroView.print(this.tabuleiro);
			if (embarcacao != null) {
				MensageiroView.imprimeStatusJogo(this.pontuacao,
						tabuleiro.getQtdeEmbarcacoesRestantes(),
						embarcacao.getNome());
			} else {
				MensageiroView.imprimeStatusJogo(this.pontuacao, tabuleiro.getQtdeEmbarcacoesRestantes());
			}
		}
		
		// verificando o resultado final do jogo:
		MensageiroView.imprimeLinha();
		if (this.pontuacao == 0) {
			MensageiroView.imprimeLinha("\tVOCE PERDEU !!!");
		} else {
			MensageiroView.imprimeLinha("\n\tVOCE VENCEU !!!  Pontuacao final: " + this.pontuacao);
		}
	}
	
	/**
	 * Efetua um disparo no tabuleiro, atualiza os pontos e as embarcacoes do jogo atual.
	 * @param alvo O alvo do disparo.
	 * @return Uma Embarcacao caso esta tenha sido destruida, caso contraio, retorna null.
	 */
	public Embarcacao disparar(String alvo)
	{
		// validando o alvo informado pelo jogador:
		if (alvo.length() != 2) {
			return null;
		}
		
		char[] arrCharAlvo = alvo.toUpperCase().toCharArray();
		// obtendo o character do numero da linha do alvo que corresponde a letra entrada pelo jogador:
		arrCharAlvo[0] = (char) ((int) arrCharAlvo[0] - 17);
		
		// verificando se os characters dos numeros dos alvos correspondem ao tamanho do tabuleiro:
		for (char c : arrCharAlvo) {
			if ((int) c < 48 || (int) c >= (48 + DIMENSOES_TABULEIRO)) {
				return null;
			}
		}
		
		int linha = Integer.parseInt(Character.toString(arrCharAlvo[0]));
		int coluna = Integer.parseInt(Character.toString(arrCharAlvo[1]));
		UnidadeTabuleiro unidade = tabuleiro.getElemento(linha, coluna);
		
		// verificando se a unidade do tabuleiro ja foi atingida previamente pelo jogador:
		if (unidade.isAtingido()) {
			return null;
		}
		unidade.marcarAtingido();
		
		this.pontuacao += PONTUACAO_POR_DISPARO;
		
		if (unidade.getEmbarcacao() != null) {
			if (unidade.getEmbarcacao().isDestruida()) {
				tabuleiro.umaEmbarcacaoFoiDestruida();
				this.pontuacao += PONTUACAO_POR_ALVO_DESTRUIDO;
				return unidade.getEmbarcacao();
			} else {
				this.pontuacao += PONTUACAO_POR_ALVO_ATINGIDO;
			}
		}
		
		return null;
	}
}
