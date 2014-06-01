package backup1;

public class ArvoreRB<T extends Comparable<T>> extends ArvoreAVL<T>
{
	@Override
	public void insert(T elemento)
	{
		Nodo<T> atual = raiz;
		Nodo<T> atualBak = null;
		int comp = 0;

		// procurando a posicao do novo nodo:
		while (atual != null) {
			atualBak = atual;
			comp = elemento.compareTo(atual.getElemento());
			if (comp < 0)
				atual = atual.getEsquerda();
			else if (comp > 0)
				atual = atual.getDireita();
			else
				return;
		}

		// criando o novo nodo e adicionando-o a arvore na posicao correta:
		Nodo<T> novo = new Nodo<T>(elemento);
		if (atualBak == null) {
			raiz = novo;
		} else {
			if (comp < 0)
				atualBak.setEsquerdaComPai(novo);
			else if (comp > 0)
				atualBak.setDireitaComPai(novo);
		}

		// iniciando a validacao da arvore:
		novo = insertCaso1(novo);
	}

	private Nodo<T> insertCaso1(Nodo<T> nodo)
	{
		if (nodo.getPai() == null)
			nodo.setCorPreto();
		else
			nodo = insertCaso2(nodo);
		return nodo;
	}

	private Nodo<T> insertCaso2(Nodo<T> nodo)
	{
		if (nodo.getPai().isCorPreto())
			return nodo;
		else
			nodo = insertCaso3(nodo);
		return nodo;
	}

	private Nodo<T> insertCaso3(Nodo<T> nodo)
	{
		Nodo<T> avo = null;
		Nodo<T> tio = nodo.getTio();
		if (tio != null && tio.isCorVermelho()) {
			nodo.getPai().setCorPreto();
			tio.setCorPreto();
			avo = nodo.getAvo();
			avo.setCorVermelho();
			avo = insertCaso1(avo);
		} else {
			nodo = insertCaso4(nodo);
		}
		return nodo;
	}

	private Nodo<T> insertCaso4(Nodo<T> nodo)
	{
		Nodo<T> pai = nodo.getPai();
		Nodo<T> avo = nodo.getAvo();
		if (nodo == pai.getDireita() && pai == avo.getEsquerda()) {
			pai = rotaEsquerda(pai);
			nodo = nodo.getEsquerda();
		} else if (nodo == pai.getEsquerda() && pai == avo.getDireita()) {
			pai = rotaDireita(pai);
			nodo = nodo.getDireita();
		}
		nodo = insertCaso5(nodo);
		return nodo;
	}

	private Nodo<T> insertCaso5(Nodo<T> nodo)
	{
		Nodo<T> avo = nodo.getAvo();
		nodo.getPai().setCorPreto();
		avo.setCorVermelho();
		if (nodo == nodo.getPai().getEsquerda())
			avo = rotaDireita(avo);
		else
			avo = rotaEsquerda(avo);
		return nodo;
	}
	
	private Nodo<T> maximumNode(Nodo<T> n)
	{
		while (n.getDireita() != null)
			n = n.getDireita();
		return n;
	}
	
	private void replaceNode(Nodo<T> oldn, Nodo<T> newn)
	{
		if (oldn.getPai() == null) {
			raiz = newn;
		} else {
			if (oldn == oldn.getPai().getEsquerda())
				oldn.getPai().setEsquerda(newn);
			else
				oldn.getPai().setDireita(newn);
		}
		if (newn != null)
			newn.setPai(oldn.getPai());
	}

	public void delete(T elemento)
	{
		Nodo<T> atual = raiz;
		int comp = 0;
		while (atual != null) {
			comp = elemento.compareTo(atual.getElemento());
			if (comp < 0)
				atual = atual.getEsquerda();
			else if (comp > 0)
				atual = atual.getDireita();
			else
				break;
		}
		
		if (atual == null)
			return;
		
		if (atual.getEsquerda() != null && atual.getDireita() != null) {
			Nodo<T> pred = maximumNode(atual.getEsquerda());
			atual.setElemento(pred.getElemento());
			atual = pred;
		}
		
		Nodo<T> filho = (atual.getDireita() == null ? atual.getEsquerda() : atual.getDireita());
		if (filho != null)
			atual.setCor(filho.getCor());
		
		if (atual.isCorPreto())
			deleteCaso1(atual);
		replaceNode(atual, filho);
	}

	/*
	 * Se N eh raiz:
	 * 	termina
	 * Senao:
	 * 	segue para caso2 em N
	 */
	private void deleteCaso1(Nodo<T> n)
	{
		System.out.println("caso1");
		if (n.getPai() != null)
			deleteCaso2(n);
	}

	/*
	 * Se o nodo (N) e o pai (P) sao pretos e o irmao (S) eh vermelho:
	 * 	pinta P de vermelho
	 * 	pinta S de preto
	 * 	Se N eh filho a esquerda:
	 * 		rotaciona a esquerda em P
	 * 	Ja se N eh filho a direita:
	 * 		rotaciona a direita em P
	 * 	segue para caso3 em N
	 */
	private void deleteCaso2(Nodo<T> n)
	{
		System.out.println("caso2");
		Nodo<T> p = n.getPai();
		Nodo<T> s = n.getIrmao();
		if (n.isCorPreto() && p.isCorPreto() && s.isCorVermelho()) {
			p.setCorVermelho();
			s.setCorPreto();
			if (n.isFilhoEsquerda())
				p = rotaEsquerda(p);
			else
				p = rotaDireita(p);
		}
		deleteCaso3(n);
	}

	/*
	 * Se N, P, S e of filhos de S sao pretos:
	 * 	pinta S de vermelho
	 * 	volta para o caso1 em P
	 * segue para caso4 em N
	 */
	private void deleteCaso3(Nodo<T> n)
	{
		System.out.println("caso3");
		Nodo<T> p = n.getPai();
		Nodo<T> s = n.getIrmao();
		if (n.isCorPreto() && p.isCorPreto() && s.isCorPreto()
				&& (s.getEsquerda() == null || s.getEsquerda().isCorPreto())
				&& (s.getDireita() == null || s.getDireita().isCorPreto())) {
			s.setCorVermelho();
			deleteCaso1(p);
		} else {
			deleteCaso4(n);
		}
	}

	/*
	 * Se N, S e os filhos de S sao pretos e P eh vermelho:
	 * 	pinta P de preto
	 * 	pinta S de vermelho
	 * 	termina
	 * Senao:
	 * 	segue para caso5 em N
	 */
	private void deleteCaso4(Nodo<T> n)
	{
		System.out.println("caso4");
		Nodo<T> p = n.getPai();
		Nodo<T> s = n.getIrmao();
		if (n.isCorPreto() && p.isCorVermelho() && s.isCorPreto()
				&& (s.getEsquerda() == null || s.getEsquerda().isCorPreto()
				&& (s.getDireita() == null || s.getDireita().isCorPreto()))) {
			p.setCorPreto();
			s.setCorVermelho();
		} else {
		}
		deleteCaso5(n);
	}

	/*
	 * Se N eh filho a esquerda, S e o filho a direita de S sao pretos, e o filho a esquerda de S eh vermelho:
	 * 	pinta S de vermelho
	 * 	pinta o filho a esquerda de S de preto
	 * 	rotaciona a direita em S
	 * 	segue para caso6 em N
	 * Ja se, N eh filho a direita, S e o filho a esquerda de S sao pretos, e o filho a direita de S eh vermelho:
	 * 	pinta S de vermelho
	 * 	pinta o filho a direita de S de preto
	 * 	rotaciona a esquerda em S
	 * 	segue para caso6 em N
	 */
	private void deleteCaso5(Nodo<T> n)
	{
		System.out.println("caso5");
		Nodo<T> s = n.getIrmao();
		
//		if (s != null && s.isCorPreto()) {
//			if (n.isFilhoEsquerda()
//					&& (s.getDireita() == null || s.getDireita().isCorPreto())
//					&& (s.getEsquerda() != null && s.getEsquerda().isCorVermelho())) {
//				
//			}
//		}
		
		if (n.isFilhoEsquerda()
				&& (s != null && s.isCorPreto())
				&& (s.getDireita() == null || s.getDireita().isCorPreto())
				&& (s.getEsquerda() != null && s.getEsquerda().isCorVermelho())) {
			s.setCorVermelho();
			s.getEsquerda().setCorPreto();
			s = rotaDireita(s);
//			deleteCaso6(n);
		} else if (n.isFilhoDireita()
				&& (s != null && s.isCorPreto())
				&& (s.getEsquerda() == null || s.getEsquerda().isCorPreto())
				&& (s.getDireita() != null && s.getDireita().isCorVermelho())) {
			s.setCorVermelho();
			s.getDireita().setCorPreto();
			s = rotaEsquerda(s);
//			deleteCaso6(n);
		}
		deleteCaso6(n);
	}

	/*
	 * Se N eh o filho a esquerda, S eh preto, e o filho a direita de S eh vermelho:
	 * 	pinta S com a cor de P
	 * 	pinta P de preto
	 * 	pinta o filho a direita de S de preto
	 * 	rotaciona a esquerda em P
	 * Ja se, N eh o filho a direita, S eh preto, e o filho a esquerda de S eh vermelho:
	 * 	pinta S com a cor de P
	 * 	pinta P de preto
	 * 	pinta o filho a esquerda de S de preto
	 * 	rotaciona a direita em P
	 */
//	private void deleteCaso6(Nodo<T> n)
//	{
//		System.out.println("caso6");
//		Nodo<T> p = n.getPai();
//		Nodo<T> s = n.getIrmao();
//		if (n.isFilhoEsquerda()
//				&& (s != null && s.isCorPreto())
//				&& (s.getDireita() != null && s.getDireita().isCorVermelho())) {
//			s.setCor(p.getCor());
//			p.setCorPreto();
//			s.getDireita().setCorPreto();
//			p = rotaEsquerda(p);
//		} else if (n.isFilhoDireita()
//				&& (s != null && s.isCorPreto())
//				&& (s.getEsquerda() != null && s.getEsquerda().isCorVermelho())) {
//			s.setCor(p.getCor());
//			p.setCorPreto();
//			s.getEsquerda().setCorPreto();
//			p = rotaDireita(p);
//		}
//		System.out.println(p.getElemento());
//	}

	private void deleteCaso6(Nodo<T> n)
	{
		System.out.println("caso6");
		Nodo<T> p = n.getPai();
		Nodo<T> s = n.getIrmao();
//		s.setCor(p.getCor());
//		p.setCorPreto();
//		if (s.isCorPreto()) {
			if (n.isFilhoEsquerda()) {
//				s.setCor(p.getCor());
				p.setCorPreto();
				s.getDireita().setCorPreto();
				p = rotaEsquerda(p);
			} else {
//				s.setCor(p.getCor());
				p.setCorPreto();
				s.getEsquerda().setCorPreto();
				p = rotaDireita(p);
			}
//		}
	}
}
