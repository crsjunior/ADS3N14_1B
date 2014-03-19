package view;

public class ExtendedContatoView extends ContatoView
{
	@Override
	public void printContato(String nome, String telefone)
	{
		System.out.println("   CONTATO");
		System.out.println("   Nome: " + nome);
		System.out.println("   Telefone: " + telefone);
	}
}
