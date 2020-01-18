package application;

/**
 * Weapon class. Has fields of ROCK, PAPER, SCISSORS.
 */
public enum Weapon {

    /**
     * Rock weapon. Beats scissors but losses to paper.
     */
    ROCK,
    /**
     * Paper weapon. Beats rock but losses to scissors.
     */
    PAPER,
    /**
     * Scissors weapon. Beats paper but losses to rock.
     */
    SCISSORS;

	
	   /**
     * Compares the weapons given.
     * @param weapon1 User's weapon.
     * @return Numerical value indicating win, loss, or tie.
     */
    public int compare(Weapon weapon) {

        int compare = 0;

        switch (this) {
            case ROCK:
                switch (weapon) {
                    case PAPER:
                        compare = -1;
                        break;
                    case SCISSORS:
                        compare = 1;
                        break;
                }
                break;
            case PAPER:
                switch (weapon) {
                    case SCISSORS:
                        compare = -1;
                        break;
                    case ROCK:
                        compare = 1;
                        break;
                }
                break;
            case SCISSORS:
                switch (weapon) {
                    case ROCK:
                        compare = -1;
                        break;
                    case PAPER:
                        compare = 1;
                        break;
                }
                break;
        }
        return compare;
    }
	
    @Override
    public String toString() {
        String wString = "";
        switch (this) {
            case ROCK:
                wString = "R";
                break;
            case PAPER:
                wString = "P";
                break;
            case SCISSORS:
                wString = "S";
                break;
        }
        return wString;
    }

    public String toFullString() {
        String wString = "";
        switch (this) {
            case ROCK:
                wString = "Rock";
                break;
            case PAPER:
                wString = "Paper";
                break;
            case SCISSORS:
                wString = "Scissors";
                break;
        }
        return wString;
    }
}