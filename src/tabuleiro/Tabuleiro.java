package tabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Pecas[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Pecas[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Pecas pecas(int linha, int coluna) {
		if(!posicaoExiste(linha, coluna)) {
			throw new TabuleiroExcecao("posicao inacessivel");
		}
		return pecas[linha][coluna];
	}
	public Pecas pecas(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroExcecao("posicao inacessivel");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void lugarPeca(Pecas peca, Posicao posicao) {
		if(pecaExiste(posicao)) {
			throw new TabuleiroExcecao("Ja existe uma peca nessa posicao" + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	public Pecas removerPeca(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroExcecao("posicao inexistente");
		}
		if(pecas(posicao) == null) return null;
		//p remover, tenho q criar uma aux
		Pecas aux = pecas(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
		
	}
	public boolean posicaoExiste(int lin, int col) {
		if (lin >= 0 && lin < linhas && col >= 0 && col < colunas) {
			return true;
		}
		return false;
	}
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	public boolean pecaExiste(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroExcecao("posicao inacessivel");
		}
		if(pecas(posicao)!=null) {
			return true;
		}		
		return false;

	}
	
	
}
