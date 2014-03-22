package exercicio5;

import exercicio3.Comodo;
import exercicio4.Chave;

public class Exercicio5
{
	public static void main(String[] args)
	{
		Comodo cozinha = new Comodo(10.0f, "CINZA CLARO", "COZINHA");
		Comodo corredor = new Comodo(7f, "BRANCO", "CORREDOR");
		
		Chave chaveCozinha = new Chave(12);
		Chave chavePortao = new Chave(18);
		Porta portaCozinha = new Porta(12);
		
		portaCozinha.printEstado("Porta nova para a cozinha.");
		
		portaCozinha.instalarPorta(cozinha, corredor);
		portaCozinha.printEstado("Instalando porta na cozinha.");
		
		portaCozinha.desinstalarPorta();
		portaCozinha.printEstado("Desinstalando porta da cozinha para reforma.");
		
		portaCozinha.instalarPorta(cozinha, corredor);
		portaCozinha.printEstado("Reinstalando porta reformada na cozinha.");
		
		portaCozinha.abrirFechar();
		portaCozinha.printEstado("Tentando abrir/fechar a cozinha.");
		
		portaCozinha.destrancarTrancar(chavePortao);
		portaCozinha.printEstado("Tentando destrancar/trancar a cozinha com a chave do portao.");
		
		portaCozinha.destrancarTrancar(chaveCozinha);
		portaCozinha.printEstado("Tentando destrancar/trancar a cozinha com a chave da cozinha.");
		
		portaCozinha.abrirFechar();
		portaCozinha.printEstado("Tentando abrir/fechar a cozinha.");
	}
}
