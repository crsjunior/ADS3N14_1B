package controller;

import model.Contato;
import estruturas.ListaContatosOrdenada;
import estruturas.Nodo;

public class ListaContatosOrdenadaIterator
{
	private ListaContatosOrdenada lista;
	private Nodo<Contato> nodo;
	private boolean novo;
	
	public ListaContatosOrdenadaIterator(ListaContatosOrdenada lista) {
		this.lista = lista;
		this.nodo = this.lista.getHead();
		this.novo = true;
	}
	
	public Contato getContato()
	{
		return this.nodo.getData();
	}
	
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
