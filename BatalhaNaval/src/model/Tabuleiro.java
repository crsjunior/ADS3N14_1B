package model;

import java.util.Arrays;
import java.util.Random;

import model.Embarcacao.Alinhamento;
import model.estruturas.Matriz;

public class Tabuleiro extends Matriz
{
	private int qtdeEmbarcacoesRestantes;
	
	public Tabuleiro(int qtdeLinhas, int qtdeColunas)
	{
		super(qtdeLinhas, qtdeColunas);
		this.qtdeEmbarcacoesRestantes = 0;
	}
	
	@Override
	public UnidadeTabuleiro[] getLinha(int linha)
	{
		return Arrays.copyOf(super.getLinha(linha), super.getQtdeColunas(), UnidadeTabuleiro[].class);
	}
	
	@Override
	public UnidadeTabuleiro[] getColuna(int coluna)
	{
		return Arrays.copyOf(super.getColuna(coluna), super.getQtdeLinhas(), UnidadeTabuleiro[].class);
	}
	
	@Override
	public UnidadeTabuleiro getElemento(int linha, int coluna)
	{
		return (UnidadeTabuleiro) super.getElemento(linha, coluna);
	}
	
	public int getQtdeEmbarcacoesRestantes()
	{
		return qtdeEmbarcacoesRestantes;
	}
	
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
