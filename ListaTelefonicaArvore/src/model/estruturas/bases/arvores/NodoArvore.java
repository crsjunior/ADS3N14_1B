package model.estruturas.bases.arvores;

public class NodoArvore<T extends Comparable<T>> implements Comparable<NodoArvore<T>>
{
	private T data = null;
	private NodoArvore<T> left = null;
	private NodoArvore<T> right = null;

	public NodoArvore() { }

	public NodoArvore(T data) { this.data = data; }

	public T getData() { return data; }

	public void setData(T data) { this.data = data; }

	public NodoArvore<T> getLeft() { return left; }

	public void setLeft(NodoArvore<T> left) { this.left = left; }

	public NodoArvore<T> getRight() { return right; }

	public void setRight(NodoArvore<T> right) { this.right = right; }

	@Override
	public int compareTo(NodoArvore<T> nodo)
	{
		return data.compareTo(nodo.getData());
	}
}
