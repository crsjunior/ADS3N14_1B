package model;

import java.util.Arrays;
import java.util.Random;

import model.Embarcacao.Alinhamento;
import model.estruturas.Matriz;

public class Tabuleiro extends Matriz
{
	private int qtdeEmbarcacoesRestantes;
	
	/**
	 * Cria um tabuleiro de batalha naval.
	 * @param qtdeLinhas A quantidade de linhas do tabuleiro.
	 * @param qtdeColunas A quantidade de colunas do tabuleiro.
	 */
	public Tabuleiro(int qtdeLinhas, int qtdeColunas)
	{
		super(qtdeLinhas, qtdeColunas);
		this.qtdeEmbarcacoesRestantes = 0;
	}
	
	/**
	 * Retorna uma array contendo uma linha do tabuleiro.
	 * @return Uma array contendo uma linha do tabuleiro.
	 */
	@Override
	public UnidadeTabuleiro[] getLinha(int linha)
	{
		return Arrays.copyOf(super.getLinha(linha), super.getQtdeColunas(), UnidadeTabuleiro[].class);
	}
	
	/**
	 * Retorna uma array contendo uma coluna do tabuleiro.
	 * @return Uma array contendo uma coluna do tabuleiro.
	 */
	@Override
	public UnidadeTabuleiro[] getColuna(int coluna)
	{
		return Arrays.copyOf(super.getColuna(coluna), super.getQtdeLinhas(), UnidadeTabuleiro[].class);
	}
	
	/**
	 * Retorna uma unidade do tabuleiro.
	 * @param linha O numero da linha da unidade.
	 * @param coluna O numero da coluna da unidade.
	 * @return Uma unidade do tabuleiro.
	 */
	@Override
	public UnidadeTabuleiro getElemento(int linha, int coluna)
	{
		return (UnidadeTabuleiro) super.getElemento(linha, coluna);
	}
	
	/**
	 * Retorna a quantidade de embarcacoes do tabuleiro que ainda nao foram destruidas.
	 * @return A quantidade de embarcacoes que ainda nao foram destruidas.
	 */
	public int getQtdeEmbarcacoesRestantes()
	{
		return qtdeEmbarcacoesRestantes;
	}
	
	/**
	 * Sinaliza que uma embarcacao do tabuleiro foi destruida.
	 */
	public void umaEmbarcacaoFoiDestruida()
	{
		--this.qtdeEmbarcacoesRestantes;
	}
	
	/**
	 * Adiciona uma embarcacao ao tabuleiro.
	 * @param embarcacao A embarcacao a ser inserida.
	 * @param linha A linha do tabuleiro onde sera inserida a embarcacao.
	 * @param coluna A coluna do tabuleiro onde sera inserida a embarcacao.
	 */
	public void addEmbarcacao(Embarcacao embarcacao, int linha, int coluna)
	{
		if (embarcacao.getAlinhamento() == Alinhamento.HORIZONTAL) {
			for (int i = 0; i < embarcacao.getTamanho(); i++) {
				super.setElemento(embarcacao.getElementos()[i], linha, coluna + i);
			}
		} else {
			for (int i = 0; i < embarcacao.getTamanho(); i++) {
				super.setElemento(embarcacao.getElementos()[i], linha + i, coluna);
			}
		}
		++this.qtdeEmbarcacoesRestantes;
	}
	
	/**
	 * Adiciona uma embarcacao ao tabuleiro, sorteando sua posicao em uma regiao disponivel.
	 * @param embarcacao A embarcacao a ser inserida.
	 */
	public void addEmbarcacaoPorSorteio(Embarcacao embarcacao)
	{
		Random random = new Random();
		UnidadeTabuleiro[] elementosLinhaColuna;
		int linha = 0;
		int coluna = 0;
		boolean sorteioOk = false;
		
		if (embarcacao.getAlinhamento() == Alinhamento.HORIZONTAL) {
			while (!sorteioOk) {
				linha = random.nextInt(super.getQtdeLinhas());
				coluna = random.nextInt(super.getQtdeColunas() - embarcacao.getTamanho() + 1);
				elementosLinhaColuna = this.getLinha(linha);
				for (int i = coluna; i < (coluna + embarcacao.getTamanho()); i++) {
					sorteioOk = (elementosLinhaColuna[i] == null);
					if (!sorteioOk) {
						break;
					}
				}
			}
		} else {
			while (!sorteioOk) {
				linha = random.nextInt(super.getQtdeLinhas() - embarcacao.getTamanho() + 1);
				coluna = random.nextInt(super.getQtdeColunas());
				elementosLinhaColuna = this.getColuna(coluna);
				for (int i = linha; i < (linha + embarcacao.getTamanho()); i++) {
					sorteioOk = (elementosLinhaColuna[i] == null);
					if (!sorteioOk) {
						break;
					}
				}
			}
		}
		
		addEmbarcacao(embarcacao, linha, coluna);
	}
	
	/**
	 * Apos todas as embarcacoes estarem posicionadas, finaliza a montagem do tabuleiro.
	 */
	public void finalizarMontagemTabuleiro()
	{
		for (int linha = 0; linha < super.getQtdeLinhas(); linha++) {
			for (int coluna = 0; coluna < super.getQtdeColunas(); coluna++) {
				if (super.getMatriz()[coluna][linha] == null) {
					super.setElemento(new UnidadeTabuleiro(null), linha, coluna);
				}
			}
		}
	}
}
