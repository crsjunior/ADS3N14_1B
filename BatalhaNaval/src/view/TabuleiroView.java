package view;

import model.Tabuleiro;

abstract public class TabuleiroView
{
	abstract public void print(Tabuleiro tabuleiro);
	
	protected String stringRepeat(String texto, int repeticoes)
	{
		String valor = "";
		for (int i = 0; i < repeticoes; i++) {
			valor += texto;
		}
		return valor;
	}
}
