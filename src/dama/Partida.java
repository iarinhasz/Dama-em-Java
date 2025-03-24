package dama;

import dama.pecas.PecaNormal;
import tabuleiro.Pecas;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Partida {
	
	private Tabuleiro tab;
	private int pontosBranco = 0;
	private int pontosPreto = 0;


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
		if (!isMovimentoValido(source, target)) {
			throw new DamaExcecao("Movimento inválido! Apenas movimentos diagonais são permitidos.");
		}
	
		Pecas p = tab.removerPeca(source);
		Pecas captura = tab.removerPeca(target);
		tab.lugarPeca(p, target);
	
		// Se for um movimento de captura, remover a peça do meio
		if (Math.abs(source.getLinha() - target.getLinha()) == 2) {
			int midLinha = (source.getLinha() + target.getLinha()) / 2;
			int midColuna = (source.getColuna() + target.getColuna()) / 2;
			tab.removerPeca(new Posicao(midLinha, midColuna));
		}
		
		if (pecaCapturada != null) {
            if (p.getCor() == Cor.BRANCO) {
                pontosBranco++;
            } else {
                pontosPreto++;
            }
        }

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
	private boolean isMovimentoValido(Posicao source, Posicao target) {
		int diffLinha = Math.abs(target.getLinha() - source.getLinha());
		int diffColuna = Math.abs(target.getColuna() - source.getColuna());
	
		// O movimento deve ser diagonal (diferença de linha e coluna iguais)
		if (diffLinha != diffColuna) {
			return false;
		}
	
		// O movimento normal de uma peça deve ser apenas uma casa
		if (diffLinha == 1) {
			return true;
		}
	
		// Caso seja um movimento de captura, deve ser exatamente duas casas e a peça adversária estar no meio
		if (diffLinha == 2) {
			int midLinha = (source.getLinha() + target.getLinha()) / 2;
			int midColuna = (source.getColuna() + target.getColuna()) / 2;
			Pecas pecaNoMeio = tab.pecas(midLinha, midColuna);
	
			return pecaNoMeio != null && pecaNoMeio instanceof PecaDama &&
				   ((PecaDama) pecaNoMeio).getCor() != ((PecaDama) tab.pecas(source)).getCor();
		}
	
		return false;
	}
	
    
	
}
