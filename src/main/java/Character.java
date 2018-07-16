import static Constants.CharacterConstants.*;

public class Character {

    private int health;
    private int level;
    private boolean alive;

    public int getHealth() {return this.health;}
    public void setLevel(int l) {this.level = l;}
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

    public void dealDmg(Character c, int hp) throws InvalidTargetException {
        if(c.equals(this)) throw new InvalidTargetException("I'm a friendly target");
        int finalHP = ((this.level) >= c.getLevel() + LEVEL_DIFF) ? (hp + hp/2) :
                ((this.level) <= c.getLevel() - LEVEL_DIFF) ? (hp - hp/2) : hp ;
        c.damage(finalHP);
    }

    public void heal(int hp) {
        this.health = ((this.health + hp) < MAX_HEALTH) ? this.health + hp : MAX_HEALTH;
    }

    public void dealHeal(Character c, int hp) throws InvalidTargetException {
        if(!c.isAlive()) throw new InvalidTargetException("I'm already dead");
        if(!c.equals(this)) throw new InvalidTargetException("I'm an enemy target");
        c.heal(hp);
    }

    class InvalidTargetException extends Exception {
        public InvalidTargetException(String message) {super(message);}
    }
}
