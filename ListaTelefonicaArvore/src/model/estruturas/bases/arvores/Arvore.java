package model.estruturas.bases.arvores;

import model.estruturas.bases.listas.ListaEncadeada;
import model.estruturas.bases.listas.NodoLista;

public class Arvore<T extends Comparable<T>>
{
	private NodoArvore<T> root = null;

	public Arvore() { }

	public NodoArvore<T> getRoot() { return root; }

	public void insert(NodoArvore<T> nodoNovo)
	{
		root = insert(root, nodoNovo);
	}

	private NodoArvore<T> insert(NodoArvore<T> nodoAtual, NodoArvore<T> nodoNovo)
	{
		if (nodoAtual == null) { return nodoNovo; }

		if (nodoNovo.compareTo(nodoAtual) < 0)
			nodoAtual.setLeft(insert(nodoAtual.getLeft(), nodoNovo));
		else if (nodoNovo.compareTo(nodoAtual) > 0)
			nodoAtual.setRight(insert(nodoAtual.getRight(), nodoNovo));

		return nodoAtual;
	}

	public NodoArvore<T> search(T data)
	{
		return search(root, data);
	}

	private NodoArvore<T> search(NodoArvore<T> nodoAtual, T data)
	{
		if (nodoAtual == null)
			return null;
		if (data.compareTo(nodoAtual.getData()) < 0)
			return search(nodoAtual.getLeft(), data);
		else if (data.compareTo(nodoAtual.getData()) > 0)
			return search(nodoAtual.getRight(), data);
		else
			return nodoAtual;
	}
	
	public ListaEncadeada<NodoArvore<T>> preOrder()
	{
		ListaEncadeada<NodoArvore<T>> lista = new ListaEncadeada<NodoArvore<T>>();
		preOrder(getRoot(), lista);
		return lista;
	}
	
	private void preOrder(NodoArvore<T> nodoAtual, ListaEncadeada<NodoArvore<T>> lista)
	{
		if (nodoAtual == null) { return; }
		
		lista.append(new NodoLista<NodoArvore<T>>(nodoAtual));
		preOrder(nodoAtual.getLeft(), lista);
		preOrder(nodoAtual.getRight(), lista);
	}

	public ListaEncadeada<NodoArvore<T>> inOrder()
	{
		ListaEncadeada<NodoArvore<T>> lista = new ListaEncadeada<NodoArvore<T>>();
		inOrder(getRoot(), lista);
		return lista;
	}

	private void inOrder(NodoArvore<T> nodoAtual, ListaEncadeada<NodoArvore<T>> lista)
	{
		if (nodoAtual == null) { return; }

		inOrder(nodoAtual.getLeft(), lista);
		lista.append(new NodoLista<NodoArvore<T>>(nodoAtual));
		inOrder(nodoAtual.getRight(), lista);
	}
	
	public ListaEncadeada<NodoArvore<T>> postOrder()
	{
		ListaEncadeada<NodoArvore<T>> lista = new ListaEncadeada<NodoArvore<T>>();
		postOrder(getRoot(), lista);
		return lista;
	}
	
	private void postOrder(NodoArvore<T> nodoAtual, ListaEncadeada<NodoArvore<T>> lista)
	{
		if (nodoAtual == null) { return; }
		
		postOrder(nodoAtual.getLeft(), lista);
		postOrder(nodoAtual.getRight(), lista);
		lista.append(new NodoLista<NodoArvore<T>>(nodoAtual));
	}
}
