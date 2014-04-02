package view;

import static java.lang.System.out;

import java.util.Scanner;

public class InteracaoUsuarioView
{
	private static Scanner scanner;
	
	public static String solicitarEntrada(String mensagem)
	{
		scanner = new Scanner(System.in);
		out.print(mensagem);
		return scanner.nextLine();
	}
}
