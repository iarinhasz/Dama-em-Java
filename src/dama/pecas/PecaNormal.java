package dama.pecas;

import dama.Cor;
import dama.PecaDama;
import tabuleiro.Tabuleiro;

public class PecaNormal extends PecaDama{

	public PecaNormal(Tabuleiro tab, Cor cor) {
		super(tab, cor);
		// TODO Auto-generated constructor stub
	}
	@Override
    public String toString() {
        return "PN";
    }
}
