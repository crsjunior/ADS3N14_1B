package model.estruturas;

public class Matriz
{
	private int qtdeLinhas;
	private int qtdeColunas;
	private UnidadeMatriz[][] matriz;
	
	/**
	 * Constroi uma matriz bidimensional.
	 * @param qtdeLinhas Quantidade de linhas.
	 * @param qtdeColunas Quantidade de colunas.
	 */
	public Matriz(int qtdeLinhas, int qtdeColunas)
	{
		this.qtdeLinhas = qtdeLinhas;
		this.qtdeColunas = qtdeColunas;
		this.matriz = new UnidadeMatriz[qtdeLinhas][qtdeColunas];
	}
	
	/**
	 * Retorna a quantidade de linhas da matriz bidimensional.
	 * @return A quantidade de linhas da matriz bidimensional.
	 */
	public int getQtdeLinhas()
	{
		return qtdeLinhas;
	}
	
	/**
	 * Retorna a quantidade de colunas da matriz bidimensional.
	 * @return A quantidade de colunas da matriz bidimensional.
	 */
	public int getQtdeColunas()
	{
		return qtdeColunas;
	}
	
	/**
	 * Retorna a matriz bidimensional.
	 * @return A matriz bidimensional.
	 */
	public UnidadeMatriz[][] getMatriz()
	{
		return matriz;
	}
	
	/**
	 * Retorna uma array contendo uma linha da matriz bidimensional.
	 * @param linha O numero da linha.
	 * @return Uma array contendo a linha da matriz bidimensional.
	 */
	public UnidadeMatriz[] getLinha(int linha)
	{
		UnidadeMatriz[] arrLinha = new UnidadeMatriz[qtdeColunas];
		for (int i = 0; i < qtdeColunas; i++) {
			arrLinha[i] = matriz[i][linha];
		}
		return arrLinha;
	}
	
	/**
	 * Retorna uma array contendo uma coluna da matriz bidimensional.
	 * @param coluna O numero da coluna.
	 * @return Uma array contendo coluna da matriz bidimensional.
	 */
	public UnidadeMatriz[] getColuna(int coluna)
	{
//		UnidadeMatriz[] arrColuna = new UnidadeMatriz[qtdeLinhas];
//		for (int i = 0; i < qtdeLinhas; i++) {
//			arrColuna[i] = matriz[coluna][i];
//		}
//		return arrColuna;
		return matriz[coluna];
	}
	
	/**
	 * Retorna um elemento da matriz bidimensional.
	 * @param linha O numero da linha do elemento.
	 * @param coluna O numero da coluna do elemento.
	 * @return Um elemento da matriz bidimensional.
	 */
	public UnidadeMatriz getElemento(int linha, int coluna)
	{
		return matriz[coluna][linha];
	}
	
	/**
	 * Substitui um elemento da matriz bidimensional.
	 * @param dado O novo valor do elemento da matriz bidimensional.
	 * @param linha A numero da linha do elemento.
	 * @param coluna O numero da coluna do elemento.
	 */
	public void setElemento(UnidadeMatriz dado, int linha, int coluna)
	{
		matriz[coluna][linha] = dado;
	}
}
