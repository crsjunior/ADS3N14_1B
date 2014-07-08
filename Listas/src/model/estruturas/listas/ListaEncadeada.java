package model.estruturas.listas;

import java.util.Iterator;

public class ListaEncadeada<T extends Comparable<T>> implements Iterable<T>
{
	protected Nodo<T> primeiro;
	protected Nodo<T> ultimo;
	protected int tamanho;

	/**
	 * Constroi uma lista encadeada vazia.
	 */
	public ListaEncadeada()
	{
		this.primeiro = null;
		this.ultimo = null;
		this.tamanho = 0;
	}

	public Nodo<T> getPrimeiro()
	{
		return primeiro;
	}

	public int getTamanho()
	{
		return tamanho;
	}

	public T get(int indice)
	{
		if (indice > tamanho - 1) {
			throw new IndexOutOfBoundsException("Indice: " + indice + ", Tamanho: " + tamanho);
		}

		Nodo<T> atual = null;
		if (indice < tamanho / 2) {
			atual = primeiro;
			for (int i = 0; i < indice; i++) {
				atual = atual.getProximo();
			}
		} else {
			atual = ultimo;
			for (int i = tamanho - 1; i > indice; i--) {
				atual = atual.getAnterior();
			}
		}
		return atual.getDado();
	}

	public void insert(Nodo<T> novo)
	{
		if (primeiro == null) {
			ultimo = novo;
		} else {
			primeiro.setAnterior(novo);
		}
		novo.setAnterior(null);
		novo.setProximo(primeiro);
		primeiro = novo;
		++tamanho;
	}

	protected void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		if (anterior == ultimo) {
			novo.setAnterior(ultimo);
			novo.setProximo(null);
			ultimo.setProximo(novo);
			ultimo = novo;
		} else {
			novo.setAnterior(anterior);
			novo.setProximo(anterior.getProximo());
			novo.getProximo().setAnterior(novo);
			anterior.setProximo(novo);
		}
		++tamanho;
	}

	public void delete(Nodo<T> nodo)
	{
		Nodo<T> n = procurar(nodo);
		if (n == null) {
			return;
		}
		if (primeiro == ultimo) {
			primeiro = null;
			ultimo = null;
		} else if (n == primeiro) {
			primeiro = n.getProximo();
			primeiro.setAnterior(null);
		} else if (n == ultimo) {
			ultimo = n.getAnterior();
			ultimo.setProximo(null);
		} else {
			n.getAnterior().setProximo(n.getProximo());
			n.getProximo().setAnterior(n.getAnterior());
		}
		--tamanho;
	}

	private Nodo<T> procurar(Nodo<T> nodo)
	{
		Nodo<T> atual = primeiro;
		while (atual != null) {
			if (atual.compareTo(nodo) == 0) {
				return atual;
			}
			atual = atual.getProximo();
		}
		return null;
	}

	@Override
	public Iterator<T> iterator()
	{
		Iterator<T> iterator = new Iterator<T>()
		{
			private Nodo<T> atual = primeiro;

			@Override
			public boolean hasNext()
			{
				return atual != null;
			}

			@Override
			public T next()
			{
				T dado = atual.getDado();
				atual = atual.getProximo();
				return dado;
			}

			@Override
			public void remove()
			{
			}
		};
		return iterator;
	}
}
