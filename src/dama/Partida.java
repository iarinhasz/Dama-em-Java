package dama;

import dama.pecas.PecaNormal;
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
	
	private void configurarSetupInicial() {
	    // Colocar peças normais brancas nas linhas 0, 2 e 6
	    for (int linha = 0; linha < 3; linha++) {
	        for (int coluna = 0; coluna < tab.getColunas(); coluna++) {
	            if ((linha + coluna) % 2 != 0) {
	                tab.lugarPeca(new PecaNormal(tab, Cor.BRANCO), new Posicao(linha, coluna));
	            }
	        }
	    }
	    
	    // Colocar peças normais vermelhas nas linhas 5, 6 e 7
	    for (int linha = 5; linha < tab.getLinhas(); linha++) {
	        for (int coluna = 0; coluna < tab.getColunas(); coluna++) {
	            if ((linha + coluna) % 2 != 0) {
	                tab.lugarPeca(new PecaNormal(tab, Cor.VERMELHO), new Posicao(linha, coluna));
	            }
	        }
	    }
	}
    
	
}
