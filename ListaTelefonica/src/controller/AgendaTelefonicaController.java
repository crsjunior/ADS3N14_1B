package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Contato;
import view.InteracaoUsuarioView;
import view.CompactContatoView;
import view.ContatoView;
import view.ExtendedContatoView;
import estruturas.ListaContatosEncadeada;
import estruturas.ListaContatosOrdenada;
import estruturas.Nodo;

public class AgendaTelefonicaController
{
	private static final String arqDados = "ListaTelefonicaDados.txt";
	private static ListaContatosEncadeada lce;
	private static ListaContatosOrdenada lco;
	private InteracaoUsuarioView interacaoUsuarioView;
	
	/**
	 * Cria o controller da agenda telefonica.
	 */
	public AgendaTelefonicaController()
	{
		interacaoUsuarioView = new InteracaoUsuarioView();
	}
	
	/**
	 * Inicia a agenda telefonica.
	 */
	public void run()
	{
		AgendaTelefonicaController.recuperarDados();
		
		int opcao;
		do {
			opcao = interacaoUsuarioView.menuPrincipal();
			switch (opcao) {
				case 1:
					novo();
					break;
				case 2:
					listar();
					break;
				case 3:
					listarOrdenada();
					break;
				case 4:
					pesquisar();
					break;
			}
		} while (opcao != 0);
		
		AgendaTelefonicaController.salvarDador();
	}
	
	/**
	 * Cria e adiciona um novo contato na agenda telefonica.
	 */
	public void novo()
	{
		Contato novoContato = interacaoUsuarioView.novoContato();
		lce.append(novoContato);
		lco.insert(novoContato);
	}
	
	/**
	 * Lista os contatos na ordem em que foram criados.
	 */
	public void listar()
	{
		ListaContatosEncadeadaIterator iterator = new ListaContatosEncadeadaIterator(lce);
		ContatoView v = new CompactContatoView();
		Contato c;
		System.out.println();
		while (iterator.hasNext()) {
			c = iterator.getContato();
			exibirContato(v, c);
		}
	}
	
	/**
	 * Lista os contatos ordenados pelos seus nomes.
	 */
	public void listarOrdenada()
	{
		ListaContatosOrdenadaIterator iterator = new ListaContatosOrdenadaIterator(lco);
		ContatoView v = new CompactContatoView();
		Contato c;
		System.out.println();
		while (iterator.hasNext()) {
			c = iterator.getContato();
			exibirContato(v, c);
		}
	}
	
	/**
	 * Pesquisa por um contato especifico.
	 */
	public void pesquisar()
	{
		String termo = interacaoUsuarioView.pesquisarContatoPorNome();
		Contato c = lce.procuraPorNome(termo);
		if (c != null) {
			System.out.println();
			exibirContato(new ExtendedContatoView(), c);
			if (interacaoUsuarioView.menuExcluirContato() == true) {
				excluirContato(c);
			}
		} else {
			System.out.println("Nenhum contato encontrado!");
		}
	}
	
	/**
	 * Exibe um contato.
	 * @param view Em qual view exibir o contato.
	 * @param contato Conato a ser exibido.
	 */
	private void exibirContato(ContatoView view, Contato contato)
	{
		view.printContato(contato.getNome(), contato.getTelefone());
	}
	
	private void excluirContato(Contato contato)
	{
		System.out.println("A Lista precisaria ser duplamente encadeada para excluir um contato!\n");
	}
	
	/**
	 * Recupera os dados do arquivo de dados, alimentando, com estes, as listas de contatos encadeada e ordenada.
	 */
	private static void recuperarDados()
	{
		lce = new ListaContatosEncadeada();
		lco = new ListaContatosOrdenada();
		
		if (!verificaArqDados()) {
			return;
		}
		
		try {
			FileReader arq = new FileReader(arqDados);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			
			while (linha != null) {
				Contato contato = new Contato();
				if (!linha.equals("")) {
					contato.setNome(linha.split(";")[0]);
					contato.setTelefone(linha.split(";")[1]);
					lce.append(contato);
					lco.insert(contato);
				}
				
				linha = lerArq.readLine();
			}
			
			lerArq.close();
		} catch (IOException ex) {
			System.err.println("Erro na abertura de arquivo.\n" + ex.getMessage());
		}
	}
	
	/**
	 * Salva os dados da lista de contatos encadeada no arquivo de dados.
	 */
	private static void salvarDador()
	{
		if (!verificaArqDados()) {
			return;
		}
		
		try {
			FileWriter arq = new FileWriter(arqDados);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			Nodo<Contato> nodo = lce.getHead();
			
			while (nodo != null) {
				gravarArq.println(nodo.getData().getNome() + ";" + nodo.getData().getTelefone());
				nodo = nodo.getNext();
			}
			
			gravarArq.close();
		} catch (IOException ex) {
			System.err.println("Erro na gravacao de arquivo.\n" + ex.getMessage());
		}
	}
	
	/**
	 * Verifica se o arquivo de dados existe, caso contrario, tenta cria-lo.
	 * @return True se o arquivo existe ou foi criado com sucesso, caso contrario, false.
	 */
	private static boolean verificaArqDados()
	{
		File arquivo = new File(arqDados);
		try {
			arquivo.createNewFile();
			return true;
		} catch (IOException ex) {
			System.err.println("Não foi possivel criar o arquivo de dados.\n" + ex.getMessage());
		}
		return false;
	}
}
