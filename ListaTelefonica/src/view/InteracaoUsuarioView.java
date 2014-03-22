package view;

import static java.lang.System.out;

import java.util.Scanner;

import model.Contato;

public class InteracaoUsuarioView
{
	private Scanner scanner;
	
	/**
	 * Exibe o menu de opcoes principal da agenda telefonica e retorna um Integer correspondente a entrada do usuario.
	 * @return 0-sair, 1-novo, 2-listar, 3-listar em ordem, 4-pesquisar.
	 */
	public int menuPrincipal()
	{
		scanner = new Scanner(System.in);
		int opcao;
		
		while (true) {
			out.println();
			out.println("------------------------------------------------------------------");
			out.println("      MENU DA LISTA TELEFONICA");
			out.println("   1 - Novo | 2 - Listar | 3 - Listar em ordem | 4 - Pesquisar | 0 - Sair");
			out.print("Sua opcao: ");
			opcao = scanner.nextInt();
			
			if (opcao < 0 || opcao > 4) {
				out.println("   Opcao invalida. Por favor, tente novamente.");
			} else {
				return opcao;
			}
		}
	}
	
	/**
	 * Exibe o menu que questiona o usuario se deseja excluir um contato.
	 * @return True se o usuario deseja excluir o contato, caso contrario, false.
	 */
	public boolean menuExcluirContato()
	{
		scanner = new Scanner(System.in);
		String opcao;
		while (true) {
			out.print("      Sua opcao [ S - Excluir contato | n - Voltar ]: ");
			opcao = scanner.nextLine();
			if (opcao.equals("S")) {
				return true;
			}
			if (opcao.equals("n")) {
				return false;
			}
		}
	}
	
	/**
	 * Solicita ao usuario as informacoes de um novo contato.
	 * @return O novo contato.
	 */
	public Contato novoContato()
	{
		scanner = new Scanner(System.in);
		String nome;
		String telefone;
		
		out.println();
		out.println("------------------------------------------------------------------");
		out.println("      NOVO CONTATO");
		out.print("Nome: ");
		nome = scanner.nextLine();
		out.print("Telefone: ");
		telefone = scanner.nextLine();
		
		return new Contato(nome, telefone);
	}
	
	/**
	 * Solicita ao usuario o termo de pesquisa pelo nome de um contato.
	 * @return O termo da pesquisa.
	 */
	public String pesquisarContatoPorNome()
	{
		scanner = new Scanner(System.in);
		String pesquisa;
		
		out.println();
		out.println("------------------------------------------------------------------");
		out.println("      PESQUISANDO CONTATO POR NOME");
		out.print("Pesquisar por: ");
		pesquisa = scanner.nextLine();
		
		return pesquisa;
	}
}
