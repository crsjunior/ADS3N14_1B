package model.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.entidades.Contato;
import model.estruturas.ArvoreContatos;
import model.estruturas.bases.arvores.NodoArvore;
import model.estruturas.bases.listas.ListaEncadeada;
import model.estruturas.bases.listas.NodoLista;

public class ArquivoPersistencia
{
	private String arqDados;

	public ArquivoPersistencia(String arqDados) { this.arqDados = arqDados; }

	public ArvoreContatos recuperarDados()
	{
		ArvoreContatos arvoreContatos = new ArvoreContatos();
		if (!verificaArquivo()) { return arvoreContatos; }

		try {
			FileReader arqFileReader = new FileReader(arqDados);
			BufferedReader arqReader = new BufferedReader(arqFileReader);
			String linha = arqReader.readLine();
			while (linha != null) {
				if (!linha.equals(""))
					arvoreContatos.insert(new Contato(linha.split(";")[0], linha.split(";")[1]));
				linha = arqReader.readLine();
			}
			arqReader.close();
		} catch (IOException e) {
			System.err.println("Nao foi possivel ler o arquivo de dados.\n" + e.getMessage());
		}
		return arvoreContatos;
	}

	public void salvarDados(ArvoreContatos arvoreContatos)
	{
		if (!verificaArquivo()) { return; }
		ListaEncadeada<NodoArvore<Contato>> lista = arvoreContatos.inOrder();
		NodoLista<NodoArvore<Contato>> nodoLista;
		NodoArvore<Contato> nodoArvore;

		try {
			FileWriter arqFileWriter = new FileWriter(arqDados);
			PrintWriter arqWriter = new PrintWriter(arqFileWriter);
			nodoLista = lista.getHead();
			while (nodoLista != null) {
				nodoArvore = nodoLista.getData();
				arqWriter.println(nodoArvore.getData().getNome() + ";" + nodoArvore.getData().getTelefone());
				nodoLista = nodoLista.getNext();
			}
			arqWriter.close();
		} catch (IOException e) {
			System.err.println("Nao foi possivel escrever no arquivo de dados.\n" + e.getMessage());
		}
	}

	private boolean verificaArquivo()
	{
		File arquivo = new File(arqDados);
		try {
			arquivo.createNewFile();
			return true;
		} catch (IOException e) {
			System.err.println("Nao foi possivel criar o arquivo de dados.\n" + e.getMessage());
		}
		return false;
	}
}
