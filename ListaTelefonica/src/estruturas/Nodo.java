package estruturas;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>>
{
	private T data;
	private Nodo<T> next;
	
	/**
	 * Constroi um nodo vazio.
	 */
	public Nodo()
	{
		this.data = null;
		this.next = null;
	}
	
	/**
	 * Constroi um nodo com o dado especificado.
	 * @param data O dado do nodo.
	 */
	public Nodo(T data)
	{
		this.data = data;
		this.next = null;
	}
	
	/**
	 * Retorna o dado do nodo.
	 * @return O dado do nodo.
	 */
	public T getData()
	{
		return data;
	}
	
	/**
	 * Substitui o dado do nodo.
	 * @param data O novo dado do nodo.
	 */
	public void setData(T data)
	{
		this.data = data;
	}
	
	/**
	 * Retorna o proximo nodo do encadeamento.
	 * @return O proximo nodo do encadeamento.
	 */
	public Nodo<T> getNext()
	{
		return next;
	}
	
	/**
	 * Substitui o proximo nodo do encadeamento.
	 * @param next O proximo nodo do encadeamento.
	 */
	public void setNext(Nodo<T> next)
	{
		this.next = next;
	}
	
	@Override
	public int compareTo(Nodo<T> nodo)
	{
		return this.data.compareTo(nodo.getData());
	}
}
