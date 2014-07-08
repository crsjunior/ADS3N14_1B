package model.estruturas.listas;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>>
{
	private T dado;
	private Nodo<T> anterior;
	private Nodo<T> proximo;

	public Nodo()
	{
		this(null);
	}

	public Nodo(T dado)
	{
		this.dado = dado;
		this.anterior = null;
		this.proximo = null;
	}

	public T getDado()
	{
		return dado;
	}

	public void setDado(T dado)
	{
		this.dado = dado;
	}

	public Nodo<T> getAnterior()
	{
		return anterior;
	}

	public void setAnterior(Nodo<T> anterior)
	{
		this.anterior = anterior;
	}

	public Nodo<T> getProximo()
	{
		return proximo;
	}

	public void setProximo(Nodo<T> proximo)
	{
		this.proximo = proximo;
	}

	@Override
	public int compareTo(Nodo<T> n)
	{
		return dado.compareTo(n.getDado());
	}
}
