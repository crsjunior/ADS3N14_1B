package model.estruturas;

public class Matriz
{
	private int qtdeLinhas;
	private int qtdeColunas;
	private UnidadeMatriz[][] matriz;
	
	/**
	 * Constroi uma matriz.
	 * @param qtdeLinhas Quantidade de linhas.
	 * @param qtdeColunas Quantidade de colunas.
	 */
	public Matriz(int qtdeLinhas, int qtdeColunas)
	{
		this.qtdeLinhas = qtdeLinhas;
		this.qtdeColunas = qtdeColunas;
		this.matriz = new UnidadeMatriz[qtdeLinhas][qtdeColunas];
	}
	
	public int getQtdeLinhas()
	{
		return qtdeLinhas;
	}
	
	public int getQtdeColunas()
	{
		return qtdeColunas;
	}
	
	public UnidadeMatriz[][] getMatriz()
	{
		return matriz;
	}
	
	public UnidadeMatriz[] getLinha(int linha)
	{
		UnidadeMatriz[] arrLinha = new UnidadeMatriz[qtdeColunas];
		for (int i = 0; i < qtdeColunas; i++) {
			arrLinha[i] = matriz[i][linha];
		}
		return arrLinha;
	}
	
	public UnidadeMatriz[] getColuna(int coluna)
	{
//		UnidadeMatriz[] arrColuna = new UnidadeMatriz[qtdeLinhas];
//		for (int i = 0; i < qtdeLinhas; i++) {
//			arrColuna[i] = matriz[coluna][i];
//		}
//		return arrColuna;
		return matriz[coluna];
	}
	
	public UnidadeMatriz getElemento(int linha, int coluna)
	{
		return matriz[coluna][linha];
	}
	
	public void setElemento(UnidadeMatriz dado, int linha, int coluna)
	{
		matriz[coluna][linha] = dado;
	}
}
