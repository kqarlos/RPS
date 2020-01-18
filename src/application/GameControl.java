package application;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 */
public class GameControl {

	public static void main(String[] args) {
		RPSDisplayer displayer = new RPSDisplayer();
		Player cpuPlayer = new Player();
		Player userPlayer = new Player();

		
		int rounds = Integer.parseInt(args[0]);
		int currentRound = 1;
		String input;
		Random rand = new Random();
		String[] weapons = { "r", "p", "s" };
		int userScore = 0;
		int cpuScore = 0;
		displayer.printIntroMessage();
		while (currentRound <= rounds) {
			Scanner scan = new Scanner(System.in);
			displayer.printRoundMessage(currentRound);

			input = scan.nextLine();
			
			if (input.equals("h")) {
				displayer.printHelpInfo();
			} else if (input.equals("e")) {
				currentRound = rounds+1;
			} else if (input.equals("m")) {
				displayer.printMatchInfo(cpuScore, userScore);
			} else if (input.equals("r") || input.contentEquals("p") || input.contentEquals("s")) {
				userPlayer.generateWeapon(input);
				cpuPlayer.generateWeapon(weapons[rand.nextInt(3)]);
		        int compare = 0;
		        switch (userPlayer.getWeapon()) {
		            case ROCK:
		                switch (cpuPlayer.getWeapon()) {
		                    case PAPER:
		                        compare = -1;
		                        break;
		                    case SCISSORS:
		                        compare = 1;
		                        break;
		                }
		                break;
		            case PAPER:
		                switch (cpuPlayer.getWeapon()) {
		                    case SCISSORS:
		                        compare = -1;
		                        break;
		                    case ROCK:
		                        compare = 1;
		                        break;
		                }
		                break;
		            case SCISSORS:
		                switch (cpuPlayer.getWeapon()) {
		                    case ROCK:
		                        compare = -1;
		                        break;
		                    case PAPER:
		                        compare = 1;
		                        break;
		                }
		                break;
		        }
		        if(compare == 0) {
					displayer.printTie(userPlayer.getWeapon());

		        } else if(compare == 1) {
					displayer.printWin(userPlayer.getWeapon(), cpuPlayer.getWeapon());
					userScore++;
		        } else if(compare == -1) {
					displayer.printLoss(userPlayer.getWeapon(), cpuPlayer.getWeapon());
					cpuScore++;
		        }
				currentRound++;
			}  else {
				displayer.printInvalid();
			}
		}
		displayer.printMatchInfo(cpuScore, userScore);
	}
}