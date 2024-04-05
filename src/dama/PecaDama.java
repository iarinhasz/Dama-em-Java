package dama;
import tabuleiro.Pecas;
import tabuleiro.Tabuleiro;


public class PecaDama extends Pecas {

	private Cor cor;
	
	public PecaDama(Tabuleiro tab, Cor cor) {
		super(tab);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}


}
