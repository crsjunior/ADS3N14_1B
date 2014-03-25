package view;

import static java.lang.System.out;

public class MensageiroView
{
	public static void imprime(String mensagem)
	{
		out.print(mensagem);
	}
	
	public static void imprimeLinha(String mensagem)
	{
		out.println(mensagem);
	}
	
	public static void imprimeLinha()
	{
		out.println();
	}
}
