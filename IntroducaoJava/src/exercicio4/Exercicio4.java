package exercicio4;

public class Exercicio4
{
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
