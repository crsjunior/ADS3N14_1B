package exercicio4;

public class Porta
{
	private boolean fechada;
	private boolean trancada;
	private int codigo;
	
	public Porta(int codigo)
	{
		this.fechada = true;
		this.trancada = true;
		this.codigo = codigo;
	}
	
	public boolean isFechada()
	{
		return fechada;
	}
	
	public boolean isTrancada()
	{
		return trancada;
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
	
	public void printEstado(String message)
	{
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("  PORTA - %s%n", message);
		System.out.printf(" Fechada: %b%n", fechada);
		System.out.printf("Trancada: %b%n", trancada);
	}
	
	public static void main(String[] args)
	{
		Chave chaveCozinha = new Chave(12);
		Chave chavePortao = new Chave(18);
		Porta portaCozinha = new Porta(12);
		
		portaCozinha.printEstado("Porta da cozinha recem instalada.");
		
		portaCozinha.abrirFechar();
		portaCozinha.printEstado("Tentando abrir/fechar a cozinha.");
		
		portaCozinha.destrancarTrancar(chavePortao);
		portaCozinha.printEstado("Tentando destrancar/trancar a cozinha com a chave do portao.");
		
		portaCozinha.destrancarTrancar(chaveCozinha);
		portaCozinha.printEstado("Tentando destrancar/trancar a cozinha com a chave da cozinha.");
		
		portaCozinha.abrirFechar();
		portaCozinha.printEstado("Tentando abrir/fechar a cozinha.");
		
		portaCozinha.destrancarTrancar(chaveCozinha);
		portaCozinha.printEstado("Tentando destrancar/trancar a cozinha com a chave da cozinha.");
		
		portaCozinha.abrirFechar();
		portaCozinha.printEstado("Tentando abrir/fechar a cozinha.");
		
		portaCozinha.destrancarTrancar(chavePortao);
		portaCozinha.printEstado("Tentando destrancar/trancar a cozinha com a chave do portao.");
		
		portaCozinha.destrancarTrancar(chaveCozinha);
		portaCozinha.printEstado("Tentando destrancar/trancar a cozinha com a chave da cozinha.");
	}
}
