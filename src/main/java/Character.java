import static Constants.CharacterConstants.*;

public class Character {
    private int health;
    private int level;
    private boolean alive;

    public int getHealth() {return this.health;}
    public int getLevel() {return this.level;}
    public boolean isAlive() {return this.alive;}

    public Character() {
        health = MAX_HEALTH;
        level = START_LEVEL;
        alive = true;
    }

    public void damage(int hp) {
        this.health = (this.health > hp) ? this.health - hp : 0;
        this.alive = !(this.health == 0);
    }

    public void dealDmg(Character c, int hp) {
        c.damage(hp);
    }

    public void heal(int hp) {
        this.health = ((this.health + hp) < MAX_HEALTH) ? this.health + hp : MAX_HEALTH;
    }

    public void dealHeal(Character c, int hp) throws InvalidTargetException {
        if(!c.isAlive()) throw new InvalidTargetException("I'm already dead");

        c.heal(hp);
    }

    class InvalidTargetException extends Exception {
        public InvalidTargetException(String message) {super(message);}
    }
}
