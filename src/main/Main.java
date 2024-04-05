package main;

import dama.Partida;


public class Main {

	public static void main(String[] args) {
		Partida partida = new Partida();
		Exibicao.printBoard(partida.getPeca());

	}

}
