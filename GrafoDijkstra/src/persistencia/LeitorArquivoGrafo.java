package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.grafo.Grafo;

public class LeitorArquivoGrafo
{
	private static final String arqDados = "grafo.txt";

	public static Grafo lerArquivoGrafo()
	{
		Grafo grafo = new Grafo();

		try {
			FileReader arq = new FileReader(arqDados);
			BufferedReader lerArq = new BufferedReader(arq);

			boolean setorVerticesEncontrado = false;
			boolean setorArestasEncontrado = false;
			boolean linhaConsistente;
			int linhaNumero = 0;
			String linhaConteudo;

			// iniciando a leitura do arquivo:
			linhaConteudo = lerArq.readLine();
			++linhaNumero;
			while (linhaConteudo != null) {
				// procurando pelo setor de vertices no arquivo de dados:
				if (linhaConteudo.equals("vertices")) {
					setorVerticesEncontrado = true;
					break;
				}
				linhaConteudo = lerArq.readLine();
				++linhaNumero;
			}

			if (setorVerticesEncontrado) {
				// lendo os vertices:
				linhaConteudo = lerArq.readLine();
				++linhaNumero;
				while (linhaConteudo != null) {
					// procurando pelo setor de arestas no arquivo de dados:
					if (linhaConteudo.equals("arestas")) {
						setorArestasEncontrado = true;
						break;
					}

					linhaConsistente = true;
					String[] partesLinhas = linhaConteudo.split(" ");

					// validando os dados da linha como sendo de um vertice:
					linhaConsistente = partesLinhas.length == 3;
					if (linhaConsistente) {
						try {
							int id = Integer.parseInt(partesLinhas[0]);
							double latitude = Double.parseDouble(partesLinhas[1]);
							double longitude = Double.parseDouble(partesLinhas[2]);
							grafo.insertVertice(id, latitude, longitude);
						} catch (Exception ex) {
							linhaConsistente = false;
						}
					}

					if (!linhaConsistente)
						System.out.println("Inconsistencia de dados na linha " + linhaNumero);
					linhaConteudo = lerArq.readLine();
					++linhaNumero;
				}
			}

			if (setorArestasEncontrado) {
				// lendo os arestas:
				linhaConteudo = lerArq.readLine();
				++linhaNumero;
				while (linhaConteudo != null) {
					linhaConsistente = true;
					String[] partesLinhas = linhaConteudo.split(" ");

					// validando os dados da linha como sendo de uma aresta:
					linhaConsistente = partesLinhas.length == 3;
					if (linhaConsistente) {
						try {
							int origem = Integer.parseInt(partesLinhas[0]);
							int destino = Integer.parseInt(partesLinhas[1]);
							double custo = Double.parseDouble(partesLinhas[2]);
							grafo.insertAresta(origem, destino, custo);
						} catch (Exception ex) {
							linhaConsistente = false;
						}
					}

					if (!linhaConsistente) {
						System.out.println("Inconsistencia de dados na linha " + linhaNumero);
					}
					linhaConteudo = lerArq.readLine();
					++linhaNumero;
				}
			}

			lerArq.close();
		} catch (IOException ex) {
			System.err.println("Erro na abertura/leitura do arquivo de dados.\n" + ex.getMessage());
		}

		return grafo;
	}
}
