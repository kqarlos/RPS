package application;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 */
public class GameControl {

	public static void main(String[] args) {

		int rounds = Integer.parseInt(args[0]);
		int currentRound = 1;
		String input;
		Random rand = new Random();
		char[] weapons = { 'r', 'p', 's' };
		int userScore = 0;
		int cpuScore = 0;

		while (currentRound <= rounds) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Round " + currentRound);

			input = scan.nextLine();

			char cpuWeapon = weapons[rand.nextInt(2) + 1];

			if (input.equals('r')) {
				if (cpuWeapon == 'r') {
					System.out.println("TIE!");
				} else if (cpuWeapon == 'p') {
					System.out.println("LOOSE!");
					cpuScore++;
				} else if (cpuWeapon == 's') {
					System.out.println("WIN!!");
					userScore++;

				}
			} else if (input.equals('p')) {
				if (cpuWeapon == 'r') {
					System.out.println("WIN!");
					userScore++;
				} else if (cpuWeapon == 'p') {
					System.out.println("TIE!");
				} else if (cpuWeapon == 's') {
					System.out.println("LOOSE!");
					cpuScore++;
				}
			} else if (input.equals('s')) {
				if (cpuWeapon == 'r') {
					System.out.println("LOOSE!");
					cpuScore++;
				} else if (cpuWeapon == 'p') {
					System.out.println("WIN!");
					userScore++;
				} else if (cpuWeapon == 's') {
					System.out.println("TIE!");

				}
			}
			currentRound++;
		}
		
		System.out.println("GAME OVER!");
		System.out.println("Your score:" + userScore + "CPU score: " + cpuScore);

	}
}