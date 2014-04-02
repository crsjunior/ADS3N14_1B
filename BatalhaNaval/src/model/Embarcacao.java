package model;

import java.util.Random;

abstract public class Embarcacao
{
	private String nome;
	private int tamanho;
	private Alinhamento alinhamento;
	private UnidadeTabuleiro[] elementos;
	private int atingidos;
	
	public Embarcacao()
	{
		
	}
	
	public Embarcacao(String nome, int tamanho)
	{
		this(nome, tamanho, Embarcacao.sorteiaAlinhamento());
	}
	
	public Embarcacao(String nome, int tamanho, Alinhamento alinhamento)
	{
		this.nome = nome;
		this.tamanho = tamanho;
		this.alinhamento = alinhamento;
		this.elementos = new UnidadeTabuleiro[tamanho];
	}
	
	public int getAtingidos()
	{
		return atingidos;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public int getTamanho()
	{
		return tamanho;
	}
	
	public Alinhamento getAlinhamento()
	{
		return alinhamento;
	}
	
	public UnidadeTabuleiro[] getElementos()
	{
		return elementos;
	}
	
	protected void atualizaUnidades()
	{
		atingidos = 0;
		for (UnidadeTabuleiro elemento : elementos) {
			if (elemento.isAtingido()) {
				++atingidos;
			}
		}
	}
	
	public boolean isDestruida()
	{
		return (atingidos == this.tamanho);
	}
	
	private static Alinhamento sorteiaAlinhamento()
	{
		return (new Random().nextInt(2) == 0 ? Alinhamento.HORIZONTAL : Alinhamento.VERTICAL);
	}
	
	protected enum Alinhamento
	{
		HORIZONTAL,
		VERTICAL
	}
}
