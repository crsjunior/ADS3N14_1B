package view;

import static java.lang.System.out;
import model.Tabuleiro;
import model.UnidadeTabuleiro;

public class SimpleTabuleiroView extends TabuleiroView
{
	@Override
	public void print(Tabuleiro tabuleiro)
	{
		// codigo ascii referente ao character da letra 'A':
		char letra = 65;
		UnidadeTabuleiro unidade;
		
		// imprimindo a linha com os numeros identificadores das colunas:
		out.printf("%n%s%n%n      ", stringRepeat("-", 57));
		for (int coluna = 0; coluna < tabuleiro.getQtdeColunas(); coluna++) {
			out.printf("%d    ", coluna);
		}
		
		// imprimindo as linhas do tabuleiro, cada uma iniciando com as suas letras identificadoras:
		for (int linha = 0; linha < tabuleiro.getQtdeLinhas(); linha++) {
			// imprimindo a letra identificadora da linha:
			out.printf("%n%n %s  ", String.valueOf(letra));
			
			// imprimindo as embarcacoes da linha:
			for (int coluna = 0; coluna < tabuleiro.getQtdeColunas(); coluna++) {
				unidade = (UnidadeTabuleiro) tabuleiro.getMatriz()[coluna][linha];
				
				if (unidade.isAtingido()) {
					if (unidade.getEmbarcacao() == null) {
						out.print("  -  ");
					} else {
						out.print("  O  ");
					}
				} else {
					out.print("  .  ");
				}
			}
			++letra;
		}
		out.print("\n\n");
	}
}
