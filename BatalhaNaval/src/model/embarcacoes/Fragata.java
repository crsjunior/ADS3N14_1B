package model.embarcacoes;

import model.UnidadeTabuleiro;
import model.Embarcacao;

public class Fragata extends Embarcacao
{
	/**
	 * Cria uma embarcacao do tipo fragata.
	 */
	public Fragata()
	{
		super("Fragata", 3);
		for (int i = 0; i < super.getTamanho(); i++) {
			super.getElementos()[i] = new UnidadeTabuleiro(this);
		}
	}
}
