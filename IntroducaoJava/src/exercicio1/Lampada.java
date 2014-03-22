package exercicio1;

public class Lampada
{
	private boolean ligado = false;
	
	public boolean isLigado()
	{
		return ligado;
	}
	
	public void ligarDeslidar()
	{
		ligado = !ligado;
	}
	
	public static void main(String[] args)
	{
		Lampada lampada = new Lampada();
		
		System.out.printf("Ligada: %b%n", lampada.isLigado());
		
		lampada.ligarDeslidar();
		System.out.printf("Ligada: %b%n", lampada.isLigado());
		
		lampada.ligarDeslidar();
		System.out.printf("Ligada: %b%n", lampada.isLigado());
	}
}
