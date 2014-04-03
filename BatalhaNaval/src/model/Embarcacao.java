package model;

import java.util.Random;

abstract public class Embarcacao
{
	private String nome;
	private int tamanho;
	private Alinhamento alinhamento;
	private UnidadeTabuleiro[] elementos;
	private int atingidos;
	
	/**
	 * Constroi uma embarcacao.
	 */
	public Embarcacao()
	{
		
	}
	
	/**
	 * Controi uma embarcacao.
	 * @param nome O nome da embarcacao.
	 * @param tamanho O tamanho (quantidade) de unidades da embarcacao (no tabuleiro).
	 */
	public Embarcacao(String nome, int tamanho)
	{
		this(nome, tamanho, Embarcacao.sorteiaAlinhamento());
	}
	
	/**
	 * Controi uma embarcacao.
	 * @param nome O nome da embarcacao.
	 * @param tamanho O tamanho (quantidade) de unidades da embarcacao (no tabuleiro).
	 * @param alinhamento O alinhamento da embarcacao (no tabuleiro).
	 */
	public Embarcacao(String nome, int tamanho, Alinhamento alinhamento)
	{
		this.nome = nome;
		this.tamanho = tamanho;
		this.alinhamento = alinhamento;
		this.elementos = new UnidadeTabuleiro[tamanho];
	}
	
	/**
	 * Retorna a quantidade de unidades da embarcacao que ja foram atingidos.
	 * @return A quantidade de unidades atingidos.
	 */
	public int getAtingidos()
	{
		return atingidos;
	}
	
	/**
	 * Retorna o nome da embarcacao.
	 * @return O nome da embarcacao.
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * Retorna o tamanho (quantidade de unidades) da embarcacao.
	 * @return O tamanho (quantidade de unidades) da embarcacao.
	 */
	public int getTamanho()
	{
		return tamanho;
	}
	
	/**
	 * Retorna o alinhamento da embarcacao.
	 * @return O alinhamento da embarcacao.
	 */
	public Alinhamento getAlinhamento()
	{
		return alinhamento;
	}
	
	/**
	 * Retorna uma array contendo as unidades da embarcacao.
	 * @return A array contendo as unidades da embarcacao.
	 */
	public UnidadeTabuleiro[] getElementos()
	{
		return elementos;
	}
	
	/**
	 * Atualiza a numero (quantidade) de unidades da embarcacao que ja foram atingidas.
	 */
	protected void atualizaUnidades()
	{
		atingidos = 0;
		for (UnidadeTabuleiro elemento : elementos) {
			if (elemento.isAtingido()) {
				++atingidos;
			}
		}
	}
	
	/**
	 * Retorna um boolean indicando se a embarcacao esta com todas as suas unidades destruidas.
	 * @return True se a embarcacao estiver destruida, caso contrario, false.
	 */
	public boolean isDestruida()
	{
		return (atingidos == this.tamanho);
	}
	
	/**
	 * Sorteia, aleatoriamente, um alinhamento para a embarcacao.
	 * @return O alinhamento sorteado.
	 */
	private static Alinhamento sorteiaAlinhamento()
	{
		return (new Random().nextInt(2) == 0 ? Alinhamento.HORIZONTAL : Alinhamento.VERTICAL);
	}
	
	protected enum Alinhamento
	{
		/**
		 * Indica um alinhamento horizontal para uma embarcacao.
		 */
		HORIZONTAL,
		/**
		 * Indica um alinhamento vertical para uma embarcacao.
		 */
		VERTICAL
	}
}
