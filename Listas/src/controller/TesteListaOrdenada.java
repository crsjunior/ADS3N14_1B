package controller;

import model.estruturas.listas.ListaOrdenada;
import model.estruturas.listas.Nodo;

public class TesteListaOrdenada
{
	public static void main(String[] args)
	{
		Nodo<Integer> n1 = new Nodo<Integer>(1);
		Nodo<Integer> n2 = new Nodo<Integer>(2);
		Nodo<Integer> n3 = new Nodo<Integer>(3);
		Nodo<Integer> n4 = new Nodo<Integer>(4);

		ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();

		lista.insert(n1);
		lista.insert(n3);
		lista.insert(n4);
		lista.insert(n2);

		int indice = 3;
		System.out.println("Obtendo dado da lista por indice:");
		System.out.println("indice: " + indice + "  |  dado: " + lista.get(indice));

		System.out.println();
		System.out.println("Iterando lista:");
		for (Integer i : lista) {
			System.out.println(i);
		}
	}
}
