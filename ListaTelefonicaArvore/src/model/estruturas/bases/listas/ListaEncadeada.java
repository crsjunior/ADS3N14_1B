package model.estruturas.bases.listas;

import java.util.Iterator;

public class ListaEncadeada<T extends Comparable<T>> implements Iterable<NodoLista<T>>
{
	private class ListaIterator<K extends Comparable<K>> implements Iterator<NodoLista<K>>
	{
		private NodoLista<K> nodoAtual;

		public ListaIterator(NodoLista<K> nodoAtual)
		{
			this.nodoAtual = nodoAtual;
		}

		@Override
		public boolean hasNext()
		{
			return (nodoAtual != null);
		}

		@Override
		public NodoLista<K> next()
		{
			NodoLista<K> nodoRetorno = nodoAtual;
			nodoAtual = nodoAtual.getNext();
			return nodoRetorno;
		}

		@Override
		public void remove() { }
	}

	private NodoLista<T> head = null;
	private NodoLista<T> tail = null;

	public NodoLista<T> getHead() { return head; }

	public NodoLista<T> getTail() { return tail; }

	public void insert(NodoLista<T> nodoNovo)
	{
		nodoNovo.setNext(head);
		if (head != null)
			head.setPrevious(nodoNovo);
		head = nodoNovo;
		if (tail == null)
			tail = nodoNovo;
	}

	public void insert(NodoLista<T> nodoNovo, NodoLista<T> nodoAnterior)
	{
		if (nodoAnterior == null) {
			nodoNovo.setNext(head);
			head = nodoNovo;
			if (tail == null)
				tail = head;
		} else {
			nodoNovo.setNext(nodoAnterior.getNext());
			nodoNovo.setPrevious(nodoAnterior);
			nodoAnterior.setNext(nodoNovo);
			if (nodoAnterior == tail)
				tail = nodoNovo;
		}
	}

	public void append(NodoLista<T> nodoNovo)
	{
		if (head == null) {
			head = nodoNovo;
		} else {
			tail.setNext(nodoNovo);
			nodoNovo.setPrevious(tail);
		}
		tail = nodoNovo;
	}

	public void remove(NodoLista<T> nodo)
	{
		NodoLista<T> previous = nodo.getPrevious();
		NodoLista<T> next = nodo.getNext();
		if (previous == null)
			head = next;
		else
			previous.setNext(next);
		if (next == null)
			tail = previous;
		else
			next.setPrevious(previous);
	}

	@Override
	public Iterator<NodoLista<T>> iterator()
	{
		return new ListaIterator<T>(head);
	}
}
