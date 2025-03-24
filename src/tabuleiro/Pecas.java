package tabuleiro;

public class Pecas {
	//pecas tem posicao e esta no tabuleiro
	protected Posicao posicao;
	private Tabuleiro tab;
	
	public Pecas(Tabuleiro tab) {
		this.tab = tab;
		posicao = null;
	}

	protected Tabuleiro getTab() {
		return tab;
	}


	
}
