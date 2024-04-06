package main;

import java.util.Scanner;

import dama.Cor;
import dama.DamaPosicao;
import dama.Partida;
import dama.PecaDama;

public class Main {

    public static void main(String[] args) {
        Partida partida = new Partida();
        Cor corJogador1 = Cor.BRANCO; // Por exemplo, o jogador 1 é branco
        Cor corJogador2 = Cor.VERMELHO; // Por exemplo, o jogador 2 é vermelho
        Scanner sc = new Scanner(System.in);
        
        
        while(true) {
        	Exibicao.printBoard(partida.getPeca(), corJogador1, corJogador2);
        	System.out.println();
        	System.out.print("Source: ");
        	DamaPosicao source = Exibicao.readPosicao(sc);
        	
        	System.out.println();
        	System.out.print("Target: ");
        	DamaPosicao target = Exibicao.readPosicao(sc);
        	
        	PecaDama captura = partida.performace(source, target);
        }
    }
}
