package model.embarcacoes;

import model.UnidadeTabuleiro;
import model.Embarcacao;

public class Torpedeiro extends Embarcacao
{
	public Torpedeiro()
	{
		super("Torpedeiro", 2);
		for (int i = 0; i < super.getTamanho(); i++) {
			super.getElementos()[i] = new UnidadeTabuleiro(this);
		}
	}
}
