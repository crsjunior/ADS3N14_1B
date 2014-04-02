package model.embarcacoes;

import model.UnidadeTabuleiro;
import model.Embarcacao;

public class Destroyer extends Embarcacao
{
	public Destroyer()
	{
		super("Destroyer", 4);
		for (int i = 0; i < super.getTamanho(); i++) {
			super.getElementos()[i] = new UnidadeTabuleiro(this);
		}
	}
}
