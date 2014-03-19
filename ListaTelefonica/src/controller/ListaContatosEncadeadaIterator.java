package controller;

import model.Contato;
import estruturas.ListaContatosEncadeada;
import estruturas.Nodo;

public class ListaContatosEncadeadaIterator
{
	private ListaContatosEncadeada lista;
	private Nodo<Contato> nodo;
	private boolean novo;
	
	public ListaContatosEncadeadaIterator(ListaContatosEncadeada lista) {
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
