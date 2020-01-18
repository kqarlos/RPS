package application;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 */
public class GameControl {

	public static void main(String[] args) {
		Information info = new Information();
		RPSDisplayer displayer = new RPSDisplayer();
		Player cpuPlayer = new Player();
		Player userPlayer = new Player();

		info.setRounds(Integer.parseInt(args[0]));
		String input;
		Random rand = new Random();
		String[] weapons = { "r", "p", "s" };
		displayer.printIntroMessage();
		while (!info.matchOver()) {
			Scanner scan = new Scanner(System.in);
			displayer.printRoundMessage(info.getRound());

			input = scan.nextLine();

			if (input.equals("h")) {
				displayer.printHelpInfo();
			} else if (input.equals("e")) {
				info.end();
			} else if (input.equals("m")) {
                displayer.printMatchInfo(info.getMatchInfo());
			} else if (input.equals("r") || input.contentEquals("p") || input.contentEquals("s")) {
				userPlayer.generateWeapon(input);
				cpuPlayer.generateWeapon(weapons[rand.nextInt(3)]);
				int result = userPlayer.getWeapon().compare(cpuPlayer.getWeapon());

				if (result == 0) {
					displayer.printTie(userPlayer.getWeapon());
				} else if (result == 1) {
					displayer.printWin(userPlayer.getWeapon(), cpuPlayer.getWeapon());
				} else if (result == -1) {
					displayer.printLoss(userPlayer.getWeapon(), cpuPlayer.getWeapon());
				}
                info.updateScores(result);
                info.updateMatchInfo();
			} else {
				displayer.printInvalid();
			}
		}
        info.updateMatchInfo();
        displayer.printMatchInfo(info.getMatchInfo());
	}
}