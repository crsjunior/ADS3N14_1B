package estruturas;

public class ListaOrdenada<T extends Comparable<T>>
{
	private Nodo<T> head;
	private Nodo<T> tail;
	
	/**
	 * Constroi uma lista ordenada vazia.
	 */
	public ListaOrdenada()
	{
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * Retorna o primeiro nodo da lista ordenada.
	 * @return O primeiro nodo da lista ordenada.
	 */
	public Nodo<T> getHead()
	{
		return this.head;
	}
	
	private Nodo<T> findBefore(Nodo<T> novo)
	{
		Nodo<T> atual = this.head;
		Nodo<T> anterior = null;
		
		while (atual != null) {
			int comparacao = atual.compareTo(novo);
			if (comparacao < 0) {
				anterior = atual;
				atual = atual.getNext();
			} else if (comparacao == 0) {
				return atual;
			} else {
				break;
			}
		}
		return anterior;
	}
	
	/**
	 * Insere um nodo na lista ordenada.
	 * @param novo - nodo que sera inserido na lista.
	 */
	public void insert(Nodo<T> novo)
	{
		Nodo<T> anterior = findBefore(novo);
		
		if (anterior == null) {
			novo.setNext(this.head);
			this.head = novo;
			if (this.tail == null) {
				this.tail = this.head;
			}
		} else {
			if (this.tail == anterior) {
				this.tail.setNext(novo);
				this.tail = novo;
			} else {
				novo.setNext(anterior.getNext());
				anterior.setNext(novo);
			}
		}
	}
}
