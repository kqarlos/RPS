package application;

/**
 * This class sets the weapon for the user.
 */
public class Player {

    private Weapon weapon;

    /**
     * Returns the weapon
     * @return weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Sets the weapon 
     * @param weapon 
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * sets the weapon
     * @param input the weapon as a string
     * @return  
     */
    public Weapon generateWeapon(String input) {
        if (input.equals("r")) {
            setWeapon(Weapon.ROCK);
        }
        if (input.equals("p")) {
            setWeapon(Weapon.PAPER);
        }
        if (input.equals("s")) {
            setWeapon(Weapon.SCISSORS);
        }
        return getWeapon();
    }
}
