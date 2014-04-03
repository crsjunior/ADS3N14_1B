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
	private static final int[] DIMENSOES_TABULEIRO = new int[] { 7, 8, 10 };
	private static final int PONTUACAO_POR_DISPARO = -1;
	private static final int PONTUACAO_POR_ALVO_ATINGIDO = 3;
	private static final int PONTUACAO_POR_ALVO_DESTRUIDO = 5;
	
	private Tabuleiro tabuleiro;
	private TabuleiroView tabuleiroView;
	private int nivelDificuldade;
	private int pontuacao;
	
	/**
	 * Cria o controller do jogo batalha naval.
	 */
	public JogoController()
	{
		this.tabuleiro = null;
		this.tabuleiroView = null;
		this.nivelDificuldade = 0;
		this.pontuacao = 15;
	}
	
	/**
	 * Inicia o jogo de batalha naval.
	 */
	public void iniciar()
	{
		MensageiroView.imprimeLinha("ESCLARECIMENTO: A FUNCIONALIDADE ADICIONAL QUE DISPONIBILIZA DIFERENTES");
		MensageiroView.imprimeLinha("   NIVEIS DE DIFICULDADE SOMENTE VISA EXPOR A FLEXIBILIDADE QUE ESTA");
		MensageiroView.imprimeLinha("   FORMA DE IMPLEMENTACAO OFERECE!\n");
		
		solicitarDefinicoesJogo();
		montarTabuleiro();
		
		String entrada;
		Embarcacao embarcacao = null;
		
		tabuleiroView.print(tabuleiro);
		MensageiroView.imprimeStatusJogo(pontuacao, tabuleiro.getQtdeEmbarcacoesRestantes());
		
		while (pontuacao > 0 && tabuleiro.getQtdeEmbarcacoesRestantes() > 0) {
			entrada = InteracaoUsuarioView.solicitarEntrada("\nAlvo ('sair'): ");
			if (entrada.toLowerCase().equals("sair")) {
				break;
			}
			
			embarcacao = disparar(entrada);
			
			tabuleiroView.print(tabuleiro);
			if (embarcacao != null) {
				MensageiroView.imprimeStatusJogo(pontuacao,
						tabuleiro.getQtdeEmbarcacoesRestantes(),
						embarcacao.getNome());
			} else {
				MensageiroView.imprimeStatusJogo(pontuacao, tabuleiro.getQtdeEmbarcacoesRestantes());
			}
		}
		
		// verificando o resultado final do jogo:
		MensageiroView.imprimeLinha();
		if (pontuacao == 0) {
			MensageiroView.imprimeLinha("\tVOCE PERDEU !!!");
		} else if (tabuleiro.getQtdeEmbarcacoesRestantes() == 0) {
			MensageiroView.imprimeLinha("\tVOCE VENCEU !!!  Pontuacao final: " + pontuacao);
		}
	}
	
	/**
	 * Monta o tabuleiro para um novo jogo.
	 */
	private void montarTabuleiro()
	{
		tabuleiro = new Tabuleiro(DIMENSOES_TABULEIRO[nivelDificuldade], DIMENSOES_TABULEIRO[nivelDificuldade]);
		tabuleiro.addEmbarcacaoPorSorteio(new PortaAvioes());
		tabuleiro.addEmbarcacaoPorSorteio(new Destroyer());
		tabuleiro.addEmbarcacaoPorSorteio(new Destroyer());
		tabuleiro.addEmbarcacaoPorSorteio(new Fragata());
		tabuleiro.addEmbarcacaoPorSorteio(new Fragata());
		tabuleiro.addEmbarcacaoPorSorteio(new Torpedeiro());
		tabuleiro.addEmbarcacaoPorSorteio(new Torpedeiro());
		tabuleiro.addEmbarcacaoPorSorteio(new Torpedeiro());
		tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		tabuleiro.addEmbarcacaoPorSorteio(new Submarino());
		tabuleiro.finalizarMontagemTabuleiro();
	}
	
	/**
	 * Questiona o usuario algumas definicoes para o jogo.
	 */
	private void solicitarDefinicoesJogo()
	{
		String entrada;
		
		do {
			entrada = InteracaoUsuarioView.solicitarEntrada("Exibir grade no tabuleiro (1-Nao | 2-Sim): ");
		} while (!entrada.equals("1") && !entrada.equals("2"));
		if (entrada.equals("1")) {
			tabuleiroView = new SimpleTabuleiroView();
		} else {
			tabuleiroView = new ComplexTabuleiroView();
		}
		
		do {
			entrada = InteracaoUsuarioView.solicitarEntrada("Nivel de dificuldade (1-Facil | 2-Normal | 3-Dificil): ");
		} while (entrada.length() != 1 || entrada.charAt(0) < 49 || entrada.charAt(0) > 51);
		nivelDificuldade = Integer.parseInt(entrada) - 1;
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
			if ((int) c < 48 || (int) c >= (48 + DIMENSOES_TABULEIRO[nivelDificuldade])) {
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
		
		pontuacao += PONTUACAO_POR_DISPARO;
		
		if (unidade.getEmbarcacao() != null) {
			if (unidade.getEmbarcacao().isDestruida()) {
				tabuleiro.umaEmbarcacaoFoiDestruida();
				pontuacao += PONTUACAO_POR_ALVO_DESTRUIDO;
				return unidade.getEmbarcacao();
			} else {
				pontuacao += PONTUACAO_POR_ALVO_ATINGIDO;
			}
		}
		
		return null;
	}
}
