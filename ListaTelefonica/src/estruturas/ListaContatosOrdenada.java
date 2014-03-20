package estruturas;

import model.Contato;

public class ListaContatosOrdenada extends ListaOrdenada<Contato>
{
	/**
	 * Constroi uma lista de contatos ordenada vazia.
	 */
	public ListaContatosOrdenada()
	{
		super();
	}
	
	/**
	 * Insere um contato na lista de contatos ordenada.
	 * @param novo Contato que sera inserido na lista.
	 */
	public void insert(Contato novo)
	{
		super.insert(new Nodo<Contato>(novo));
	}
}
