package model;

import model.estruturas.UnidadeMatriz;

public class UnidadeTabuleiro extends UnidadeMatriz
{
	private Embarcacao embarcacao;
	private boolean atingido;
	
	/**
	 * Cria uma unidade de tabuleiro.
	 * @param embarcacao A embarcacao a qual esta unidade pertence.
	 */
	public UnidadeTabuleiro(Embarcacao embarcacao)
	{
		this.embarcacao = embarcacao;
		this.atingido = false;
	}
	
	/**
	 * Retorna a embarcacao a qual esta unidade pertence.
	 * @return A embarcacao a qual esta unidade pertence.
	 */
	public Embarcacao getEmbarcacao()
	{
		return embarcacao;
	}
	
	/**
	 * Retorna um boolean indicando se esta unidade ja foi atingida.
	 * @return True se esta unidade ja tiver sido atingida, caso contrario, false.
	 */
	public boolean isAtingido()
	{
		return atingido;
	}
	
	/**
	 * Marca esta unidade como sendo atingida.
	 */
	public void marcarAtingido()
	{
		this.atingido = true;
		if (this.embarcacao != null) {
			this.embarcacao.atualizaUnidades();
		}
	}
}
