package model.estruturas.bases.listas;

public class NodoLista<T extends Comparable<T>> implements Comparable<NodoLista<T>>
{
	private T data = null;
	private NodoLista<T> next = null;
	private NodoLista<T> previous = null;

	public NodoLista() { }

	public NodoLista(T data) { this.data = data; }

	public T getData() { return data; }

	public void setData(T data) { this.data = data; }

	public NodoLista<T> getNext() { return next; }

	public void setNext(NodoLista<T> next) { this.next = next; }

	public NodoLista<T> getPrevious() { return previous; }

	public void setPrevious(NodoLista<T> previous) { this.previous = previous; }

	@Override
	public int compareTo(NodoLista<T> nodo)
	{
		return data.compareTo(nodo.getData());
	}
}
