package view.interacao;

import model.entidades.Contato;
import view.tela.EscreverView;
import view.tela.LerView;

public class InteracaoUsuarioView
{
	/**
	 * Exibe o menu principal da lista telefonica.
	 * @return A opcao escolhida pelo usuario.
	 */
	public int menuPrincipal()
	{
		Integer opcao;
		while (true) {
			EscreverView.imprimeLinha();
			EscreverView.imprimeLinhaSeparadora();
			EscreverView.imprimeLinha();
			EscreverView.imprimeLinha("      << MENU PRINCIPAL DA LISTA TELEFONICA >>");
			EscreverView.imprimeLinha();
			EscreverView.imprimeLinha("( 1 ) Novo contato");
			EscreverView.imprimeLinha("( 2 ) Listar contatos");
			EscreverView.imprimeLinha("( 3 ) Pesquisar contato");
			EscreverView.imprimeLinha("( 0 ) Sair da lista telefonica");
			EscreverView.imprimeLinha();
			opcao = LerView.lerInteger("Sua opcao: ");
			if (opcao == null || opcao < 0 || opcao > 3)
				EscreverView.imprimeLinha("   Opcao invalida. Por favor, tente novamento!");
			else
				return opcao;
		}
	}

	/**
	 * Exibe o menu com as diferentes possibilidades para se listar os contatos.
	 * @return A opcao escolhida pelo usuario.
	 */
	public int menuListar()
	{
		Integer opcao;
		while (true) {
			EscreverView.imprimeLinha();
			EscreverView.imprimeLinhaSeparadora('~', 60);
			EscreverView.imprimeLinha();
			EscreverView.imprimeLinha("      << MENU LISTAR CONTATOS >>");
			EscreverView.imprimeLinha();
			EscreverView.imprimeLinha("( 1 ) Pre-Order");
			EscreverView.imprimeLinha("( 2 ) In-Order");
			EscreverView.imprimeLinha("( 3 ) Post-Order");
			EscreverView.imprimeLinha("( 0 ) Voltar para o menu principal");
			EscreverView.imprimeLinha();
			opcao = LerView.lerInteger("Sua opcao: ");
			if (opcao == null || opcao < 0 || opcao > 3) {
				EscreverView.imprimeLinha("   Opcao invalida. Por favor, tente novamento!");
			} else {
				return opcao;
			}
		}
	}

	/**
	 * Questiona o usuario sobre as informacoes de um novo conato.
	 * @return O novo contato.
	 */
	public Contato novoContato()
	{
		Contato contato = null;
		String nome;
		String telefone;
		EscreverView.imprimeLinha();
		EscreverView.imprimeLinhaSeparadora('~', 50);
		EscreverView.imprimeLinha();
		EscreverView.imprimeLinha("      << NOVO CONTATO >>");
		EscreverView.imprimeLinha();
		nome = LerView.lerString("    Nome: ");
		telefone = LerView.lerString("Telefone: ");
		EscreverView.imprimeLinha();
		if (nome.equals("") || telefone.equals("")) {
			EscreverView.imprimeLinha("Dados insuficientes. Contato nao criado!");
		} else {
			contato = new Contato(nome, telefone);
			EscreverView.imprimeLinha("Contato criado com sucesso!");
		}
		return contato;
	}

	/**
	 * Questiona o usuario sobre o termo que sera utilizado para pesquisar um contato pelo seu nome.
	 * @return O termo para ser utilizado na pesquisa.
	 */
	public String pesquisarContatoPorNome()
	{
		String termo = "";
		EscreverView.imprimeLinha();
		EscreverView.imprimeLinhaSeparadora('~', 50);
		EscreverView.imprimeLinha();
		EscreverView.imprimeLinha("      << PESQUISANDO CONTATO POR NOME >>");
		EscreverView.imprimeLinha();
		termo = LerView.lerString("Termo da pesquisa: ");
		EscreverView.imprimeLinha();
		if (termo.equals("")) {
			EscreverView.imprimeLinha("Dados incuficientes. Pesquisa cancelada!");
		}
		return termo;
	}
}
