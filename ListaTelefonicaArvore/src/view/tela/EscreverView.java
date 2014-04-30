package view.tela;

import static java.lang.System.out;

public class EscreverView
{
	private static final char caracterePadraoLinhaSeparadora = '-';
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
		imprimeLinhaSeparadora(caracterePadraoLinhaSeparadora, tamanhoPadraoLinhaSeparadora);
	}

	public static void imprimeLinhaSeparadora(char caractere)
	{
		imprimeLinhaSeparadora(caractere, tamanhoPadraoLinhaSeparadora);
	}

	public static void imprimeLinhaSeparadora(int tamanho)
	{
		imprimeLinhaSeparadora(caracterePadraoLinhaSeparadora, tamanho);
	}

	public static void imprimeLinhaSeparadora(char caractere, int tamanho)
	{
		String linhaSeparadora = "";
		for (int i = 0; i < tamanho; i++) {
			linhaSeparadora += String.valueOf(caractere);
		}
		out.println(linhaSeparadora);
	}
}
