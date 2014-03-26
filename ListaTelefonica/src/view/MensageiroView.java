package view;

import static java.lang.System.out;

public class MensageiroView
{
	private static final int tamanhoPadraoLinhaSeparadora = 70;
	
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
	
	public static void imprimeLinhaSeparadora()
	{
		imprimeLinhaSeparadora(tamanhoPadraoLinhaSeparadora);
	}
	
	public static void imprimeLinhaSeparadora(int tamanho)
	{
		String linhaSeparadora = "";
		for (int i = 0; i < tamanho; i++) {
			linhaSeparadora += "-";
		}
		out.println(linhaSeparadora);
//		out.println(String.format("%0" + tamanho + "d", 0).replace("0", "-"));
//		out.println(new String(new char[tamanho]).replace("\0", "-"));
	}
}
