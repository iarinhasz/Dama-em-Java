package dama;

import dama.pecas.PecaNormal;
import tabuleiro.Pecas;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Partida {
	
	private Tabuleiro tab;
	
	public Partida() {
		tab = new Tabuleiro(8,8);
		configurarSetupInicial();
	}
	
	public PecaDama[][] getPeca(){
		PecaDama[][] aux = new PecaDama[tab.getLinhas()][tab.getColunas()];
		for(int i = 0; i<tab.getLinhas(); i++) {
			for(int j = 0; j<tab.getColunas(); j++) {
				aux[i][j] = (PecaDama) tab.pecas(i, j);
			}
		}
		return aux;
	}
	
	public PecaDama performace(DamaPosicao sourceP, DamaPosicao targetP) {
		Posicao source = sourceP.toPosicao();
		Posicao target = targetP.toPosicao();
		Pecas captura = makeMove(source, target);
		return (PecaDama) captura;
	}
	
	private Pecas makeMove(Posicao source, Posicao target) {
		Pecas p = tab.removerPeca(source);
		Pecas captura = tab.removerPeca(target);
		tab.lugarPeca(p, target);
		return captura;
	}
	
	private void configurarSetupInicial() {
	    // Colocar peças normais brancas nas linhas 0, 2 e 6
	    for (int linha = 0; linha < 3; linha++) {
	        for (int coluna = 0; coluna < tab.getColunas(); coluna++) {
	            if ((linha + coluna) % 2 != 0) {
	                DamaPosicao posicaoDama = new DamaPosicao((char)('a' + coluna), 8 - linha);
	                Posicao posicaoTabuleiro = posicaoDama.toPosicao();
	                tab.lugarPeca(new PecaNormal(tab, Cor.BRANCO), posicaoTabuleiro);
	            }
	        }
	    }
	    
	    // Colocar peças normais vermelhas nas linhas 5, 6 e 7
	    for (int linha = 5; linha < tab.getLinhas(); linha++) {
	        for (int coluna = 0; coluna < tab.getColunas(); coluna++) {
	            if ((linha + coluna) % 2 != 0) {
	                DamaPosicao posicaoDama = new DamaPosicao((char)('a' + coluna), 8 - linha);
	                Posicao posicaoTabuleiro = posicaoDama.toPosicao();
	                tab.lugarPeca(new PecaNormal(tab, Cor.VERMELHO), posicaoTabuleiro);
	            }
	        }
	    }
	}
    
	
}
