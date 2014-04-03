package model.embarcacoes;

import model.UnidadeTabuleiro;
import model.Embarcacao;

public class Submarino extends Embarcacao
{
	/**
	 * Cria uma embarcacao do tipo submarino.
	 */
	public Submarino()
	{
		super("Submarino", 1);
		for (int i = 0; i < super.getTamanho(); i++) {
			super.getElementos()[i] = new UnidadeTabuleiro(this);
		}
	}
}
