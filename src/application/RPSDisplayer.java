package application;

/**
 * Displays information and contains the main method that runs and updates the game.
 */
public class RPSDisplayer {

    String invalid;
    private String helpInfo;
    private final String introMessage;
    private String roundMessage;

    /**
     * Constructor for the displayer class. Sets the messages.
     */
    public RPSDisplayer() {
        this.invalid = "That is not a valid input. Please enter a valid input...";
        
        this.helpInfo = "'Rock, Paper, Scissor' is a game in which players draw "
                + "their weapon and use them against each other. There are 3 weapons:\n"
                + "-Rock:'r'\tBeats scissors but losses to papers.\n"
                + "-Paper:'p'\tBeats rocks but losses to scissors.\n"
                + "-Scissor:'s'\tBeats papers but losses to rocks.\n"
                + "You are versing the computer and the computer chooses"
                + " its weapon at random. Enter your weapon to use against the computer:";
        this.introMessage = "Welcome to Rock, Paper, Scissor game!";
        this.roundMessage = "-----------------------------------------------------------------"
                + "\nRock, paper, scissor shoot!"
                + "\nEnter:'r' for rock, 'p' for paper, 's' for scissor."
                + "\nOR 'm' for match info,'h' for help, or 'e' to exit.";
    }
    
    
    /**
     * Gets the round intro message
     * @return the message
     */
    public void printRoundMessage(int rounds){
        System.out.println("\nRound " + rounds + ". " + roundMessage);
    }
    
    /**
     * Prints help information.
     */
    public void printHelpInfo() {
        System.out.println(helpInfo);
    }

    /**
     * Prints current match information.
     * @param matchInfo 
     */
    public void printMatchInfo(String matchInfo) {
        System.out.println(matchInfo);
    }

    /**
     * Prints current match information.
     */
    public void printIntroMessage() {
        System.out.println(introMessage);
    }

    /**
     * Prints the invalid input message
     */
    public void printInvalid() {
        System.out.println(invalid);
    }

    /*
     * Prints that user won
     * @param weapon1 user's Weapon
     * @param weapon2 cpu's Weapon
     */
    public void printWin(Weapon userWeapon, Weapon cpuWeapon) {
        System.out.println("User threw: " + userWeapon + "!\t CPU threw: " + cpuWeapon + "!" + "\nUser Wins!");
    }

    /*
     * Prints that user lost
     * @param weapon1
     * @param weapon2
     */
    public void printLoss(Weapon userWeapon, Weapon cpuWeapon) {
        System.out.println("User threw: " + userWeapon + "!\t CPU threw: " + cpuWeapon + "!" + "\nCPU Wins!");
    }

    /*
     * Prints that user tied
     * @param weapon1 User's Weapon which is the same as CPU's weapon.
     */
    public void printTie(Weapon weapon) {
        System.out.println("User threw: " + weapon + "!\t CPU threw: " + weapon + "!" + "\nIt's a Tie!");
    }
   
    
}
