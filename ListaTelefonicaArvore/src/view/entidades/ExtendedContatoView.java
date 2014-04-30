package view.entidades;

import view.tela.EscreverView;

public class ExtendedContatoView extends ContatoView
{
	@Override
	public void printContato(String nome, String telefone)
	{
		EscreverView.imprimeLinha("   DETALHANDO CONTATO");
		EscreverView.imprimeLinha("          Nome: " + nome);
		EscreverView.imprimeLinha("      Telefone: " + telefone);
	}
}
