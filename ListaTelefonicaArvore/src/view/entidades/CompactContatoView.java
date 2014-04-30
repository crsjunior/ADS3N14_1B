package view.entidades;

import view.tela.EscreverView;

public class CompactContatoView extends ContatoView
{
	@Override
	public void printContato(String nome, String telefone)
	{
		EscreverView.imprimeLinha(String.format("%s - %s", nome, telefone));
	}
}
