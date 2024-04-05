package main;

import dama.PecaDama;

public class Exibicao {
	public static void printBoard(PecaDama[][] pecas) {
		for(int i = 0; i<pecas.length;i++) {
			System.out.print((8-i)+ " ");
			for(int j = 0; j<pecas.length;j++) {
				printPecas(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.println(" a b c d e f ");
	}
	
	private static void printPecas(PecaDama peca) {
		if (peca == null) {
			System.out.print(" - ");
		}
		else System.out.print(peca);
	}
	
}
