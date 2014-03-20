package estruturas;

public class ListaEncadeada<T extends Comparable<T>>
{
	private Nodo<T> head;
	private Nodo<T> tail;
	
	/**
	 * Constroi uma lista encadeada vazia.
	 */
	protected ListaEncadeada()
	{
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * Retorna o primeiro nodo da lista encadeada.
	 * @return O primeiro nodo da lista encadeada.
	 */
	protected Nodo<T> getHead()
	{
		return this.head;
	}
	
	/**
	 * Insere um nodo no inicio da lista encadeada.
	 * @param novo Nodo que sera inserido na lista.
	 */
	protected void insert(Nodo<T> novo)
	{
		novo.setNext(head);
		head = novo;
		// verificando se a lista estava vazia (tail == null):
		if (tail == null) {
			tail = head;
		}
	}
	
	/**
	 * Insere um nodo em uma posicao especifica da lista encadeada.
	 * @param novo Nodo que sera inserido na lista.
	 * @param anterior Nodo apos o qual sera inserido o novo nodo.
	 */
	protected void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		// verificando se o 'anterior' eh o ultimo nodo da lista (anterior == tail):
		if (anterior == tail) {
			tail.setNext(novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}
	
	/**
	 * Insere um nodo no final da lista encadeada.
	 * @param novo Nodo que sera inserido na lista.
	 */
	protected void append(Nodo<T> novo)
	{
		if (tail == null) {
			head = novo;
		} else {
			tail.setNext(novo);
		}
		tail = novo;
	}
}
