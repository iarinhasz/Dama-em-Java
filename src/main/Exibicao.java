package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import dama.Cor;
import dama.DamaPosicao;
import dama.PecaDama;

public class Exibicao {
    // Cores ANSI para formatação de texto
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static DamaPosicao readPosicao(Scanner sc) {
    	try {
	    	String s = sc.nextLine();
	    	char col = s.charAt(0);
	    	int lin = Integer.parseInt(s.substring(1));
	    	return new DamaPosicao(col, lin);
    	}
    	catch(RuntimeException e) {
    		throw new InputMismatchException("erro");
    	}
    }
    
    public static void printBoard(PecaDama[][] board, Cor corJogador1, Cor corJogador2) {
        int linhas = board.length;
        int colunas = board[0].length;

        System.out.println("\n    a   b   c   d   e   f   g   h");
        System.out.println("  ---------------------------------");

        for (int i = 0; i < linhas; i++) {
            System.out.print((linhas - i) + " |");
            for (int j = 0; j < colunas; j++) {
                if (board[i][j] != null) {
                    String piece = board[i][j].toString();
                    // Aplica a cor conforme o jogador
                    if (board[i][j].getCor() == corJogador1) {
                        piece = getCorJogador1() + piece + ANSI_RESET;
                    } else {
                        piece = getCorJogador2() + piece + ANSI_RESET;
                    }
                    System.out.print(" " + piece + " ");
                } else {
                    System.out.print(" - ");
                }
                System.out.print("|");
            }
            System.out.println(" " + (linhas - i));
        }

        System.out.println("  ---------------------------------");
        System.out.println("\n    a   b   c   d   e   f   g   h");
    }

    // Retorna a cor do jogador 1
    private static String getCorJogador1() {
        return ANSI_YELLOW;
    }

    // Retorna a cor do jogador 2
    private static String getCorJogador2() {
        return ANSI_RED; 
    }



}
