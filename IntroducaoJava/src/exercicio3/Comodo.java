package exercicio3;

import exercicio1.Lampada;

public class Comodo
{
	private float tamanho = 0f;
	private String cor = "";
	private String tipo = "";
	private Lampada iluminacao = null;
	
	public Comodo()
	{
		this.iluminacao = new Lampada();
	}
	
	public Comodo(float tamanho, String cor, String tipo)
	{
		this();
		this.tamanho = tamanho;
		this.cor = cor;
		this.tipo = tipo;
	}
	
	public float getTamanho()
	{
		return tamanho;
	}
	
	public void setTamanho(float tamanho)
	{
		this.tamanho = tamanho;
	}
	
	public String getCor()
	{
		return cor;
	}
	
	public void setCor(String cor)
	{
		this.cor = cor;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	
	public Lampada getIlimunacao()
	{
		return iluminacao;
	}
	
	public static void exibirComodo(Comodo comodo)
	{
		System.out.println("----------------------------------------");
		System.out.println("   DESCRICAO DO COMODO");
		System.out.printf("      Tipo: %s%n", comodo.tipo);
		System.out.printf("   Tamanho: %.02f m2%n", comodo.tamanho);
		System.out.printf("       Cor: %s%n", comodo.cor);
		System.out.printf("Iluminacao: %s%n", (comodo.getIlimunacao().isLigado() ? "ligada" : "desligada"));
	}
	
	public static void main(String[] args)
	{
		Comodo quarto = new Comodo();
		quarto.setTipo("QUARTO");
		quarto.setCor("BRANCO");
		quarto.setTamanho(6.5f);
		
		exibirComodo(quarto);
		
		quarto.getIlimunacao().ligarDeslidar();
		
		exibirComodo(quarto);
		
		quarto.getIlimunacao().ligarDeslidar();
		
		exibirComodo(quarto);
	}
}
