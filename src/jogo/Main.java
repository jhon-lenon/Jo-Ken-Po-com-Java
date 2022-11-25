package jogo;

import java.util.Scanner;

public class Main {
	
	public static JoKenPo startGame() {
		System.out.println("************** |Jo-Ken-Po| **************\n");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe seu nome: ");
		String playerName = scan.next().toUpperCase();
		
		Player user = new Player(playerName);
		Player IA = new Player("IA");
		
		System.out.println(playerName + ", Inform quantas rounds você qué jogar: ");
		int rounds = scan.nextInt();
		return new JoKenPo(user, IA, rounds);
		
	}

	public static void main(String[] args) {
		
		JoKenPo jokenpo = startGame();
		jokenpo.toPlay();
		jokenpo.showFinalResult();
	}

}
