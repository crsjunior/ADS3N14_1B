package view.tela;

import java.util.Scanner;

public class LerView
{
	public static Integer lerInteger()
	{
		try {
			return Integer.parseInt(getScanner().nextLine());
		} catch (Exception e) {
		}
		return null;
	}

	public static Integer lerInteger(String mensagem)
	{
		EscreverView.imprime(mensagem);
		return lerInteger();
	}

	public static String lerString()
	{
		return getScanner().nextLine();
	}

	public static String lerString(String mensagem)
	{
		EscreverView.imprime(mensagem);
		return lerString();
	}

	private static Scanner getScanner()
	{
		return new Scanner(System.in);
	}
}
