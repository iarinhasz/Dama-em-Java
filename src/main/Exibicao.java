package main;

import dama.PecaDama;

public class Exibicao {
    public static void printBoard(PecaDama[][] board) {
        int linhas = board.length;
        int colunas = board[0].length;

        System.out.println("\n    a   b   c   d   e   f   g   h");
        System.out.println("  ---------------------------------");

        for (int i = 0; i < linhas; i++) {
            System.out.print((linhas - i) + " |");
            for (int j = 0; j < colunas; j++) {
                if (board[i][j] != null) {
                    System.out.print(" " + board[i][j] + " ");
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
	
}
