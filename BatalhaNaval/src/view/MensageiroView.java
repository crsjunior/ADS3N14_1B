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
	
	public static void imprimeStatusJogo(int pontuacao, int embarcacoesRestantes)
	{
		out.printf("\tPontuacao: %d   |   Embarcacoes restantes: %d%n", pontuacao, embarcacoesRestantes);
	}
	
	public static void imprimeStatusJogo(int pontuacao, int embarcacoesRestantes, String nomeEmbarcacaoDestruida)
	{
		out.printf("\tEMBARCACAO DESTRUIDA: %s !%n", nomeEmbarcacaoDestruida);
		out.printf("\tPontuacao: %d   |   Embarcacoes restantes: %d%n", pontuacao, embarcacoesRestantes);
	}
}
