package exercicio5;

import exercicio3.Comodo;
import exercicio4.Chave;

public class Porta
{
	private boolean fechada;
	private boolean trancada;
	private int codigo;
	private Comodo comodoA;
	private Comodo comodoB;
	
	public Porta(int codigo)
	{
		this.fechada = true;
		this.trancada = true;
		this.codigo = codigo;
		this.comodoA = null;
		this.comodoB = null;
	}
	
	public boolean isFechada()
	{
		return fechada;
	}
	
	public boolean isTrancada()
	{
		return trancada;
	}
	
	public Comodo getComodoA()
	{
		return comodoA;
	}
	
	public Comodo getComodoB()
	{
		return comodoB;
	}
	
	public boolean isInstalada()
	{
		// Considera-se como instalada uma porta que tenha pelo menos 1 (um) comodo.
		return (comodoA != null || comodoB != null);
	}
	
	public void abrirFechar()
	{
		if (!trancada) {
			fechada = !fechada;
		}
	}
	
	public void destrancarTrancar(Chave chave)
	{
		if (fechada && codigo == chave.getCodigo()) {
			trancada = !trancada;
		}
	}
	
	public void instalarPorta(Comodo comodoA, Comodo comodoB)
	{
		this.comodoA = comodoA;
		this.comodoB = comodoB;
	}
	
	public void desinstalarPorta()
	{
		this.comodoA = null;
		this.comodoB = null;
	}
	
	public void printEstado(String message)
	{
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("  PORTA - %s%n", message);
		System.out.printf("Instalada: %b [%s - %s]%n"
				, isInstalada()
				, (comodoA != null ? comodoA.getTipo() : "")
				, (comodoB != null ? comodoB.getTipo() : "")
				);
		System.out.printf("  Fechada: %b%n", fechada);
		System.out.printf(" Trancada: %b%n", trancada);
	}
}
