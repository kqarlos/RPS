package application;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 */
public class GameControl {

	public static void main(String[] args) {
		RPSDisplayer displayer = new RPSDisplayer();
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
			String cpuWeapon = weapons[rand.nextInt(3)];

			if (input.equals("h")) {
				displayer.printHelpInfo();
			} else if (input.equals("e")) {
				currentRound = rounds+1;
			} else if (input.equals("m")) {
				displayer.printMatchInfo(cpuScore, userScore);
			} else if (input.equals("r")) {
				if (cpuWeapon.equals("r")) {
					displayer.printTie(input);
				} else if (cpuWeapon.equals("p")) {
					displayer.printLoss(input, cpuWeapon);
					cpuScore++;
				} else if (cpuWeapon.equals("s")) {
					displayer.printWin(input, cpuWeapon);
					userScore++;
				}
			} else if (input.equals("p")) {
				if (cpuWeapon.equals("r")) {
					displayer.printWin(input, cpuWeapon);
					userScore++;
				} else if (cpuWeapon.equals("p")) {
					displayer.printTie(input);
				} else if (cpuWeapon.equals("s")) {
					displayer.printLoss(input, cpuWeapon);
					cpuScore++;
				}
			} else if (input.equals("s")) {
				if (cpuWeapon.equals("r")) {
					displayer.printLoss(input, cpuWeapon);
					cpuScore++;
				} else if (cpuWeapon.equals("p")) {
					displayer.printWin(input, cpuWeapon);
					userScore++;
				} else if (cpuWeapon.equals("s")) {
					displayer.printTie(input);
				}
			}

			if (input.equals("r") || input.equals("p") || input.equals("s")) {
				currentRound++;
			}
		}

		displayer.printMatchInfo(cpuScore, userScore);

	}
}