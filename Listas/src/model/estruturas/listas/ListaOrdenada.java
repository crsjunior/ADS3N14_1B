package model.estruturas.listas;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T>
{
	@Override
	public void insert(Nodo<T> novo)
	{
		Nodo<T> anterior = procurarAnterior(novo);
		if (primeiro == null) {
			super.insert(novo);
		} else {
			super.insert(novo, anterior);
		}
	}

	private Nodo<T> procurarAnterior(Nodo<T> nodo)
	{
		Nodo<T> atual = primeiro;
		Nodo<T> anterior = null;
		while (atual != null) {
			int comparacao = atual.getDado().compareTo(nodo.getDado());
			if (comparacao < 0) {
				anterior = atual;
				atual = atual.getProximo();
			} else if (comparacao == 0) {
				return atual;
			} else {
				break;
			}
		}
		return anterior;
	}
}
