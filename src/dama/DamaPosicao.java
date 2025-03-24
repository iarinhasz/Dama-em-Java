package dama;

import tabuleiro.Posicao;

public class DamaPosicao {
	private char colunas;
	private int linhas;
	
	public DamaPosicao(char col, int linhas) {
		if( col < 'a' || col > 'h' || linhas < 1 || linhas > 8) {
			throw new DamaExcecao("nao permitido");
		}
		this.colunas = col;
		this.linhas = linhas;
	}

	public char getColunas() {
		return colunas;
	}

	public int getLinhas() {
		return linhas;
	}
	
	protected Posicao toPosicao() {
		return new Posicao(8-linhas, colunas - 'a');
	}
	protected static DamaPosicao aux(Posicao posicao) {
		return new DamaPosicao((char)( 'a' -posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + colunas + linhas;
	}

}
