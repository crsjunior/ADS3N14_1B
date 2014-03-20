package controller;

import model.Contato;
import estruturas.ListaContatosOrdenada;
import estruturas.Nodo;

public class ListaContatosOrdenadaIterator
{
	private ListaContatosOrdenada lista;
	private Nodo<Contato> nodo;
	private boolean novo;
	
	/**
	 * Cria um iterador para uma lista de contatos ordenada.
	 * @param lista A lista de contatos ordenada que sera iterada.
	 */
	public ListaContatosOrdenadaIterator(ListaContatosOrdenada lista) {
		this.lista = lista;
		this.nodo = this.lista.getHead();
		this.novo = true;
	}
	
	/**
	 * Retorna o contato atual da iteracao.
	 * @return O contato atual da iteracao.
	 */
	public Contato getContato()
	{
		return this.nodo.getData();
	}

	/**
	 * Retorna um boolean indicando se a lista de contatos ordenada ainda nao chegou ao seu final (tail).
	 * Ainda, automaticamente incrementa do nodo atual para o proximo nodo da lista.
	 * @return True se a lista ainda nao chegou ao seu final, caso contrario, false.
	 */
	public boolean hasNext()
	{
		if (this.novo) {
			this.novo = false;
		} else {
			this.nodo = this.nodo.getNext();
		}
		return (this.nodo != null);
	}
}
