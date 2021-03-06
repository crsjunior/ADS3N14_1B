package model.embarcacoes;

import model.UnidadeTabuleiro;
import model.Embarcacao;

public class PortaAvioes extends Embarcacao
{
	/**
	 * Cria uma embarcacao do tipo porta avioes.
	 */
	public PortaAvioes()
	{
		super("Porta Avioes", 5);
		for (int i = 0; i < super.getTamanho(); i++) {
			super.getElementos()[i] = new UnidadeTabuleiro(this);
		}
	}
}
