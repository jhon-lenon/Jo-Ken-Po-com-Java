package jogo;

import java.util.Random;
import java.util.Scanner;

public record JoKenPo(		
	Player user,
	Player IA,
	int rounds
) {
	void toPlay() {
		System.out.println("\n********* |Seja bem vindo(a) " + user.getName() + "| *********\n");
		
		for (int i = 1; i <= rounds; i++) {
			int choiceUser = choiceUser();
			if (choiceUser < 1 || choiceUser > 3) {
				System.out.println("\nJOGADA INVÁLIDA! (1, 2 ou 3): ");
				System.out.println("\tPONTO PARA " + IA.getName() + "\n");
				IA.incrementScore();
				//continue;
			}			
			int choiceIA = choiceIA();
			System.out.println("\n" + choiceUser + " X " + choiceIA + "\n");
						
			int result = choiceUser - choiceIA;
			winnerRound(result);
			
		}
	}
	
	public void showFinalResult() {
		System.out.println("\n**************************************************");
		
		int finalUserScore = user.getScore();
		int finalIAScore = IA.getScore();
		
		System.out.println("\n\tPLACAR FINAL: ==> " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName() + " <==");
		
		if (finalUserScore == finalIAScore) {
			System.out.println("\t\t\t==> EMPATE <==");
		} else {
			String finalWinner = (finalIAScore > finalUserScore) ? IA.getName() : user.getName(); 
			System.out.println("\n\t\t==> VENCEDOR: " + finalWinner.toUpperCase() + " <==");
		}
		
		System.out.println("\n**************************************************");
	}
	
	private void winnerRound(int result) {
		String winnerRound;
		if (result == 0) {
			winnerRound = "==> EMPATE! <==";
		} else {
			if (result == -1 || result == 2) {
				IA().incrementScore();
				winnerRound = IA().getName();
			} else {
				user.incrementScore();
				winnerRound = user.getName();
			}
		}
		System.out.println("==> Vencedor do round: " + winnerRound + " <==\n");
	}
	
	private int choiceIA() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}
	
	private int choiceUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - Pedra");
		System.out.println("2 - Papel");
		System.out.println("3 - Tesoura");
		
		System.out.println("\nInforme sua jogada: \n");
		return scan.nextInt();
		

	}
}
