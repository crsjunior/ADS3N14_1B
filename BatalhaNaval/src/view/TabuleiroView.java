package view;

import model.Tabuleiro;

abstract public class TabuleiroView
{
	abstract public void print(Tabuleiro tabuleiro);
	
	/**
	 * Repete um texto.
	 * @param texto O texto que sera repetido.
	 * @param repeticoes O numero de vezes em que o texto sera repetido.
	 * @return O texto repetido.
	 */
	protected String stringRepeat(String texto, int repeticoes)
	{
		String valor = "";
		for (int i = 0; i < repeticoes; i++) {
			valor += texto;
		}
		return valor;
	}
}
