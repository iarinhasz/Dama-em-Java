package dama.pecas;

import dama.Cor;
import dama.PecaDama;
import tabuleiro.Tabuleiro;

public class PecaRainha extends PecaDama {

	public PecaRainha(Tabuleiro tab, Cor cor) {
		super(tab, cor);
		// TODO Auto-generated constructor stub
	}
	@Override
    public String toString() {
        return "D";
    }
}
