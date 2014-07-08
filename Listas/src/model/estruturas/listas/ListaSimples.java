package model.estruturas.listas;

public class ListaSimples<T extends Comparable<T>> extends ListaEncadeada<T>
{
	public ListaSimples()
	{
		super();
	}

	public void append(Nodo<T> novo)
	{
		if (ultimo == null) {
			novo.setAnterior(null);
			primeiro = novo;
		} else {
			novo.setAnterior(ultimo);
			ultimo.setProximo(novo);
		}
		novo.setProximo(null);
		ultimo = novo;
		++tamanho;
	}
}
