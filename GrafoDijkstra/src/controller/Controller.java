package controller;

import java.util.LinkedList;
import java.util.Scanner;

import model.dijkstra.Dijkstra;
import model.grafo.Grafo;
import model.grafo.Vertice;
import persistencia.LeitorArquivoGrafo;

public class Controller
{
	public static void main(String[] args)
	{
		Grafo grafo = LeitorArquivoGrafo.lerArquivoGrafo();

		Scanner scanner = new Scanner(System.in);

		System.out.print("ID do Vertice de origem: ");
		int origem = scanner.nextInt();
		System.out.print("ID do Vertice de destino: ");
		int destino = scanner.nextInt();

		scanner.close();

		Dijkstra dijkstra = new Dijkstra(grafo);
		LinkedList<Vertice> caminho = dijkstra.executar(grafo.getVerticeById(origem), grafo.getVerticeById(destino));

		System.out.println("");
		if (caminho == null) {
			System.out.println("Rota inexistante!");
		} else {
			int passo = 0;
			for (Vertice v : caminho) {
				passo++;
				System.out.println("Passo " + passo + " -> " + v.getId());
			}
		}
	}
}
