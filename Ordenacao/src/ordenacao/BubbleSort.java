package ordenacao;

/*
 * COMO FUNCIONA:
 * - A ordenacao da array e realizada a partir do seu final em direcao ao seu inicio.
 * - Na primeira passagem pela array, compara o primeiro com o segundo iten, ordenando-os,
 * compara o segundo com o terceiro item, ordenando-os, e segue assim ate o fim da array.
 * Dessa forma, o ultimo item da array estara na posicao correta da ordenacao.
 * - Na segunda passagem pela array, repete o mesmo procedimento acima, porem segue ate
 * o penultimo item da array, ignorando o ultimo item que ja esta ordenado.
 * Dessa forma, os dois ultimos itens da array estarao na posicao correta da ordenacao.
 * - Segue repetindo o procedimento ate reste somente um item na array, que ja estara
 * na posicao correta da orenacao.
 */
public class BubbleSort
{
	/**
	 * Ordena uma array de inteiros de modo ascendente.
	 * @param array A array de inteiros que sera ordenada.
	 * @return Uma nova array de inteiros ordenada de modo ascendente.
	 */
	public static int[] sort(int[] array)
	{
		return BubbleSort.sort(array, SortOrderMode.ASC);
	}
	
	/**
	 * Ordena uma array de inteiros de modo ascendente ou descendente.
	 * @param array A array de inteiros que sera ordenada.
	 * @param order O modo em que a array sera ordenada (ASC, DESC).
	 * @return Uma nova array de inteiros ordenada.
	 */
	public static int[] sort(int[] array, SortOrderMode order)
	{
		int[] arrayCopia = BubbleSort.copiarArray(array);
		int dadoTroca;
		int indiceProximo;
		int ultimoIndice = arrayCopia.length - 1;
		
		if (order == SortOrderMode.ASC)
		{
			for (int i = ultimoIndice; i > 0; i--)
			{
				for (int j = 0; j < i; j++)
				{
					indiceProximo = j + 1;
					if (arrayCopia[j] > arrayCopia[indiceProximo])
					{
						dadoTroca = arrayCopia[j];
						arrayCopia[j] = arrayCopia[indiceProximo];
						arrayCopia[indiceProximo] = dadoTroca;
					}
				}
			}
		}
		else
		{
			for (int i = ultimoIndice; i > 0; i--)
			{
				for (int j = 0; j < i; j++)
				{
					indiceProximo = j + 1;
					if (arrayCopia[j] < arrayCopia[indiceProximo])
					{
						dadoTroca = arrayCopia[j];
						arrayCopia[j] = arrayCopia[indiceProximo];
						arrayCopia[indiceProximo] = dadoTroca;
					}
				}
			}
		}
		
		return arrayCopia;
	}
	
	/**
	 * Retorna um copia de uma array de inteiros.
	 * @param array A array de inteiros original.
	 * @return Uma copia da array de inteiros original.
	 */
	private static int[] copiarArray(int[] array)
	{
		int[] arrayCopia = new int[array.length];
		for (int i = 0; i < arrayCopia.length; i++)
		{
			arrayCopia[i] = array[i];
		}
		return arrayCopia;
	}
}
