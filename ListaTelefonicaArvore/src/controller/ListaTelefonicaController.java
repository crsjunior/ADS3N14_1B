package controller;

import model.entidades.Contato;
import model.estruturas.ArvoreContatos;
import model.estruturas.bases.arvores.NodoArvore;
import model.estruturas.bases.listas.ListaEncadeada;
import model.estruturas.bases.listas.NodoLista;
import model.persistencia.ArquivoPersistencia;
import view.entidades.CompactContatoView;
import view.entidades.ContatoView;
import view.entidades.ExtendedContatoView;
import view.interacao.InteracaoUsuarioView;
import view.tela.EscreverView;

public class ListaTelefonicaController
{
	private static final String arqDados = "ListaTelefonicaDados.txt";
	private ArvoreContatos arvore;
	private ArquivoPersistencia persistencia;
	private InteracaoUsuarioView interacaoUsuario;

	public ListaTelefonicaController()
	{
		arvore = null;
		persistencia = new ArquivoPersistencia(arqDados);
		interacaoUsuario = new InteracaoUsuarioView();
	}

	public void iniciarListaTelefonica()
	{
		arvore = persistencia.recuperarDados();

		Integer opcao;
		do {
			opcao = interacaoUsuario.menuPrincipal();
			switch (opcao) {
				case 1:
					novo();
					break;
				case 2:
					exibirMenuListar();
					break;
				case 3:
					pesquisar();
					break;
				default:
					continue;
			}
		} while (opcao != 0);

		persistencia.salvarDados(arvore);
	}

	private void novo()
	{
		Contato novoContato = interacaoUsuario.novoContato();
		if (novoContato != null) {
			arvore.insert(novoContato);
		}
	}

	private void exibirMenuListar()
	{
		ListaEncadeada<NodoArvore<Contato>> lista;

		while (true) {
			lista = new ListaEncadeada<NodoArvore<Contato>>();
			;
			Integer opcao = interacaoUsuario.menuListar();
			switch (opcao) {
				case 0:
					return;
				case 1:
					lista = arvore.preOrder();
					break;
				case 2:
					lista = arvore.inOrder();
					break;
				case 3:
					lista = arvore.postOrder();
					break;
			}

			ContatoView view = new CompactContatoView();
			EscreverView.imprimeLinha();
			EscreverView.imprimeLinha("   LISTANDO CONTATOS");
			EscreverView.imprimeLinhaSeparadora('~', 40);

			for (NodoLista<NodoArvore<Contato>> nodoLista : lista) {
				view.printContato(
						nodoLista.getData().getData().getNome(),
						nodoLista.getData().getData().getTelefone());
			}
		}
	}

	private void pesquisar()
	{
		String termo = interacaoUsuario.pesquisarContatoPorNome();
		if (termo.equals("")) {
			return;
		}
		NodoArvore<Contato> nodoArvoreContato = arvore.searchPorNome(termo);
		if (nodoArvoreContato == null) {
			EscreverView.imprimeLinha("Nenhum contato nao encontrado!");
		} else {
			new ExtendedContatoView().printContato(
					nodoArvoreContato.getData().getNome(),
					nodoArvoreContato.getData().getTelefone());
		}
	}
}
