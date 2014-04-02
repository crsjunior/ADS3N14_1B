package model;

import model.estruturas.UnidadeMatriz;

public class UnidadeTabuleiro extends UnidadeMatriz
{
	private Embarcacao embarcacao;
	private boolean atingido;
	
	public UnidadeTabuleiro(Embarcacao embarcacao)
	{
		this.embarcacao = embarcacao;
		this.atingido = false;
	}
	
	public Embarcacao getEmbarcacao()
	{
		return embarcacao;
	}
	
	public boolean isAtingido()
	{
		return atingido;
	}
	
	public void marcarAtingido()
	{
		this.atingido = true;
		if (this.embarcacao != null) {
			this.embarcacao.atualizaUnidades();
		}
	}
}
