package model;

public class Contato implements Comparable<Contato>
{
	private String nome;
	private String telefone;
	
	/**
	 * Constroi um contato.
	 */
	public Contato()
	{
		this.nome = null;
		this.telefone = null;
	}
	
	/**
	 * Constroi um contato.
	 * @param nome Nome do contato.
	 * @param telefone Telefone do contato.
	 */
	public Contato(String nome, String telefone)
	{
		this.nome = nome;
		this.telefone = telefone;
	}
	
	/**
	 * Retorna o nome do contato.
	 * @return O nome do contato.
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * Substitui o nome do contato.
	 * @param nome O novo nome do contato.
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	/**
	 * Retorna o telefone do contato.
	 * @return O telefone do contato.
	 */
	public String getTelefone()
	{
		return telefone;
	}
	
	/**
	 * Substitui o telefone do contato.
	 * @param telefone O novo telefone do contato.
	 */
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	/**
	 * Compara este contato com um outro contato, atraves dos nomes de ambos, para fins de ordenacao.
	 * @param contato O contato com o qual este contato sera comparado.
	 * @return Um Integer como resultado da comparacao.
	 * Se os nome de ambos os contatos forem iguais, retorna 0.
	 * Se o nome desta contato precede o nome do contato passado pelo parametro, retorna um Integer negativo,
	 * caso contrario, retorna um Integer positivo.
	 */
	@Override
	public int compareTo(Contato contato)
	{
		return this.nome.compareTo(contato.getNome());
	}
}
