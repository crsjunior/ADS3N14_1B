package estruturas;

import model.Contato;

public class ListaContatosEncadeada extends ListaEncadeada<Contato>
{
	/**
	 * Constroi uma lista de conatos encadeada vazia.
	 */
	public ListaContatosEncadeada()
	{
		super();
	}
	
	/**
	 * Retorna o primeiro contato da lista de contatos encadeada.
	 * @return O primeiro contato da lista de contatos encadeada.
	 */
	public Nodo<Contato> getHead()
	{
		return (Nodo<Contato>)super.getHead();
	}
	
	private Nodo<Contato> findBefore(Contato anterior)
	{
		Nodo<Contato> atual = (Nodo<Contato>)super.getHead();
		while (atual != null) {
			if ((Contato)atual.getData() == anterior) {
				return atual;
			}
			atual = (Nodo<Contato>)atual.getNext();
		}
		return atual;
	}
	
	/**
	 * Insere um contato no inicio da lista de contatos encadeada.
	 * @param novo Contato que sera inserido na lista.
	 */
	public void insert(Contato novo)
	{
		super.insert(new Nodo<Contato>(novo));
	}
	
	/**
	 * Insere um contato em uma posicao especifica da lista de contatos encadeada.
	 * @param novo Contato que sera inserido na lista.
	 * @param anterior Contato apos o qual sera inserido o novo contato.
	 */
	public void insert(Contato novo, Contato anterior)
	{
		Nodo<Contato> nodoAnterior = findBefore(anterior);
		super.insert(new Nodo<Contato>(novo), nodoAnterior);
	}
	
	/**
	 * Insere um contato no final da lista de contatos encadeada.
	 * @param novo Contato que sera inserido na lista.
	 */
	public void append(Contato novo)
	{
		super.append(new Nodo<Contato>(novo));
	}
	
	public Contato procuraPorNome(String nome)
	{
		if (nome.equals("")) {
			return null;
		}
		Nodo<Contato> nodo = super.getHead();
		
		do {
			if (nodo.getData().getNome().toLowerCase().startsWith(nome.toLowerCase())) {
				return nodo.getData();
			}
			nodo = nodo.getNext();
			
		} while (nodo != null);
		
		return null;
	}
}
