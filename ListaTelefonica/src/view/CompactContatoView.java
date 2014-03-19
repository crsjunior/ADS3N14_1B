package view;

public class CompactContatoView extends ContatoView
{
	@Override
	public void printContato(String nome, String telefone)
	{
		System.out.printf("Contato: %s - %s\n", nome, telefone);
	}
}