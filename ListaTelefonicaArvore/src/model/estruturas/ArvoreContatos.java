package model.estruturas;

import model.entidades.Contato;
import model.estruturas.bases.arvores.Arvore;
import model.estruturas.bases.arvores.NodoArvore;

public class ArvoreContatos extends Arvore<Contato>
{
	@Override
	public NodoArvore<Contato> getRoot()
	{
		return super.getRoot();
	}

	public void insert(Contato contato)
	{
		super.insert(new NodoArvore<Contato>(contato));
	}

	public NodoArvore<Contato> searchPorNome(String termo)
	{
		return searchPorNome(super.getRoot(), termo.toLowerCase());
	}

	private NodoArvore<Contato> searchPorNome(NodoArvore<Contato> nodoAtual, String termo)
	{
		if (nodoAtual == null)
			return null;
		
		if (nodoAtual.getData().getNome().toLowerCase().startsWith(termo))
			return nodoAtual;
		
		if (termo.compareTo(nodoAtual.getData().getNome().toLowerCase()) < 0)
			return searchPorNome(nodoAtual.getLeft(), termo);
		else if (termo.compareTo(nodoAtual.getData().getNome().toLowerCase()) > 0)
			return searchPorNome(nodoAtual.getRight(), termo);
		else
			return nodoAtual;
	}

//	private NodoArvore<Contato> searchPorNome(NodoArvore<Contato> nodoAtual, Contato contato)
//	{
//		if (nodoAtual == null)
//			return null;
//		
//		if (nodoAtual.getData().getNome().toLowerCase().startsWith(contato.getNome().toLowerCase()))
//			return nodoAtual;
//		
//		if (contato.getNome().toLowerCase().compareTo(nodoAtual.getData().getNome().toLowerCase()) < 0)
//			return search(nodoAtual.getLeft(), contato);
//		else if (contato.getNome().toLowerCase().compareTo(nodoAtual.getData().getNome().toLowerCase()) > 0)
//			return search(nodoAtual.getRight(), contato);
//		else
//			return nodoAtual;
//	}
}
