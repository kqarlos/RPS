package application;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores all the information of the match being played. Can also
 * determine match winner after the match is complete.
 * 
 * @version 1.0
 */
public class Information {

	private int rounds;
	private int currentRound;
	private String winner;
	private String matchInfo;
	private int wins;
	private int losses;
	private int ties;
	private boolean ended = false;

	/**
	 * Constructor for Information class. Stores all information related to the
	 * match being played.
	 */
	public Information() {
		this(0);
	}

	/**
	 * Constructor for Information class. Stores all information related to the
	 * match being played.
	 * 
	 * @param roundsPerMatch sets the number of rounds per match
	 */
	public Information(int roundsPerMatch) {
		this.rounds = roundsPerMatch;
		losses = 0;
		wins = 0;
		ties = 0;
		this.currentRound = 1;
		this.matchInfo = "Current Round: " + currentRound + "\t\tWins: " + wins + "\t\t Losses: " + losses
				+ "\t\tTies: " + ties;
	}

	/**
	 * returns the current round in the match
	 * 
	 * @return rounds
	 */
	public int getRound() {
		return this.currentRound;
	}

	/**
	 * boolean to see if the match is over.
	 * 
	 * @return true if match is over. False otherwise.
	 */
	public boolean matchOver() {
		return ended;
	}

	/**
	 * Ends match
	 */
	public void end() {
		ended = true;
	}

	/**
	 * Sets the number of rounds for the match
	 * 
	 * @param rounds rounds per match
	 */
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	/**
	 * Resets the game.
	 */
	public void reset() {
		this.currentRound = 1;
	}

	/**
	 * Updates score depending on if user wins, losses, or ties.
	 * 
	 * @param result Outcome of round
	 */
	public void updateScores(int result) {
		if (result == 0) {
			ties++;
		}
		if (result == -1) {
			losses++;
		}
		if (result == 1) {
			wins++;
		}
	}

	/**
	 * Updates the match information as a final outro message printing the winner.
	 */
	public void updateMatchInfo() {
		if (!ended) {
			if (currentRound < rounds) {
				currentRound++;
				this.matchInfo = "Current Round: " + currentRound + "\t\tWins: " + wins + "\t\t Losses: " + losses
						+ "\t\tTies: " + ties;
			} else {
				this.end();
			}

		} else {
			if (wins > losses) {
				this.winner = "User";
			} else if (wins < losses) {
				this.winner = "CPU";
			} else {
				this.winner = "Tie";
			}
			if (wins == losses) {
				this.matchInfo = "Total Rounds: " + currentRound + "    Wins: " + wins + "    Losses: " + losses
						+ "    Ties: " + ties + "    The Match ended in a: " + getMatchWinner();
			} else {
				this.matchInfo = "Total Rounds: " + currentRound + "    Wins: " + wins + "    Losses: " + losses
						+ "    Ties: " + ties + "    The winner is: " + getMatchWinner();
			}
		}

	}

	/**
	 * returns the match info as a reader friendly string after it's been updated.
	 * Can be interpreted as a toString() method of this class.
	 * 
	 * @return match info
	 */
	public String getMatchInfo() {
		return matchInfo;
	}

	/**
	 * gets the match winner. Can only be accessed if the match is over.
	 * 
	 * @return winner as a string
	 */
	public String getMatchWinner() {
		return winner;
	}
}
