package exercicio2;

public class Comodo
{
	private float tamanho = 0f;
	private String cor = "";
	private String tipo = "";
	
	public Comodo()
	{
		
	}
	
	public Comodo(float tamanho, String cor, String tipo)
	{
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
	
	public static void main(String[] args)
	{
		Comodo quarto = new Comodo();
		quarto.setTipo("QUARTO");
		quarto.setCor("BRANCO");
		quarto.setTamanho(6.5f);
		
		System.out.printf("%nCOMODO: %s - %.02f m2 - %s", quarto.tipo, quarto.tamanho, quarto.cor);
		
		Comodo banheiro = new Comodo(3.2f, "VERDE", "BANHEIRO");
		
		System.out.printf("%nCOMODO: %s - %.02f m2 - %s", banheiro.tipo, banheiro.tamanho, banheiro.cor);
	}
}
