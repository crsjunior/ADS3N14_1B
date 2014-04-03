package view;

import static java.lang.System.out;

public class MensageiroView
{
	/**
	 * Imprime uma mensagem no terminal (sem quebra de linha ao final).
	 * @param mensagem A mensagem a ser imprimida.
	 */
	public static void imprime(String mensagem)
	{
		out.print(mensagem);
	}
	
	/**
	 * Imprime uma mensagem no terminal, quebrando a linha ao final.
	 * @param mensagem A mensagem a ser imprimida.
	 */
	public static void imprimeLinha(String mensagem)
	{
		out.println(mensagem);
	}
	
	/**
	 * Imprime uma quebra de linha no terminal.
	 */
	public static void imprimeLinha()
	{
		out.println();
	}
	
	/**
	 * Imprime o status do jogo atual.
	 * @param pontuacao A pontuacao atual do jogador.
	 * @param embarcacoesRestantes A quantidade de embarcacoes do tabuleiro que ainda nao foram destruidas.
	 */
	public static void imprimeStatusJogo(int pontuacao, int embarcacoesRestantes)
	{
		out.printf("\tPontuacao: %d   |   Embarcacoes restantes: %d%n", pontuacao, embarcacoesRestantes);
	}
	
	/**
	 * Imprime o status do jogo atual.
	 * @param pontuacao A pontuacao atual do jogador.
	 * @param embarcacoesRestantes A quantidade de embarcacoes do tabuleiro que ainda nao foram destruidas.
	 * @param nomeEmbarcacaoDestruida O nome da embarcacao que foi destruida.
	 */
	public static void imprimeStatusJogo(int pontuacao, int embarcacoesRestantes, String nomeEmbarcacaoDestruida)
	{
		out.printf("\tEMBARCACAO DESTRUIDA: %s !%n", nomeEmbarcacaoDestruida);
		out.printf("\tPontuacao: %d   |   Embarcacoes restantes: %d%n", pontuacao, embarcacoesRestantes);
	}
}
