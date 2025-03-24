package dama;
import tabuleiro.Pecas;
import tabuleiro.Tabuleiro;



public class PecaDama extends Pecas {

	private Cor cor;
	private boolean dama; // Indica se a peça é uma dama (rainha)
	
	public PecaDama(Tabuleiro tab, Cor cor) {
		super(tab);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
    public void tornarDama() {
        this.dama = true;
    }
}
