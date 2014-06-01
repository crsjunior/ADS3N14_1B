package backup1;

import java.util.ArrayList;
import java.util.List;

abstract public class Arvore<T extends Comparable<T>>
{
	protected Nodo<T> raiz;

	public Arvore()
	{
		this.raiz = null;
	}

	public Nodo<T> getRaiz()
	{
		return raiz;
	}

	abstract public void insert(T elemento);

	public List<T> preOrder()
	{
		List<T> lista = new ArrayList<T>();
		preOrder(raiz, lista);
		return lista;
	}

	private void preOrder(Nodo<T> atual, List<T> lista)
	{
		if (atual == null)
			return;
		lista.add(atual.getElemento());
		preOrder(atual.getEsquerda(), lista);
		preOrder(atual.getDireita(), lista);
	}
}
