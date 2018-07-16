import org.junit.Assert;
import org.junit.Test;
import static Constants.CharacterConstants.*;

public class CharacterTest {

    @Test
    public void testCreateCharacter() {
        Character pj = new Character();

        Assert.assertEquals(MAX_HEALTH, pj.getHealth());
        Assert.assertEquals(START_LEVEL, pj.getLevel());
        Assert.assertTrue(pj.isAlive());
    }

    @Test
    public void testDamageCharacter() throws Character.InvalidTargetException {
        Character pj = new Character();
        Character target = new Character();

        pj.dealDmg(target, 457);
        Assert.assertEquals(543, target.getHealth());
    }

    @Test
    public void testKillCharacter() throws Character.InvalidTargetException {
        Character pj = new Character();
        Character target = new Character();

        pj.dealDmg(target, 1500);
        Assert.assertEquals(0, target.getHealth());
        Assert.assertFalse(target.isAlive());
    }

    @Test
    public void testHealCharacter() throws Character.InvalidTargetException {
        Character pj = new Character();
        Character target = new Character();

        pj.dealDmg(target, 457);
        target.dealHeal(target, 200);
        Assert.assertEquals(743, target.getHealth());
    }

    @Test
    public void testOverHealCharacter() throws Character.InvalidTargetException {
        Character pj = new Character();
        Character target = new Character();

        pj.dealDmg(target, 457);
        target.dealHeal(target, 800);
        Assert.assertEquals(1000, target.getHealth());
    }

    @Test (expected = Character.InvalidTargetException.class)
    public void testHealDeadCharacter() throws Character.InvalidTargetException {
        Character pj = new Character();
        Character target = new Character();

        pj.dealDmg(target, 1457);
        target.dealHeal(target, 200);
    }

    @Test (expected = Character.InvalidTargetException.class)
    public void testSelfDamage() throws Character.InvalidTargetException {
        Character pj = new Character();

        pj.dealDmg(pj, 457);
    }

    @Test (expected = Character.InvalidTargetException.class)
    public void testHealEnemy() throws Character.InvalidTargetException {
        Character pj = new Character();
        Character target = new Character();

        pj.dealDmg(target, 1457);
        pj.dealHeal(target, 200);
    }

    @Test
    public void testDamageCharacterHigherLevel() throws Character.InvalidTargetException {
        Character pj = new Character();
        Character target = new Character();

        pj.setLevel(6);
        pj.dealDmg(target, 100);
        Assert.assertEquals(850, target.getHealth());
    }

    @Test
    public void testDamageCharacterLowerLevel() throws Character.InvalidTargetException {
        Character pj = new Character();
        Character target = new Character();

        target.setLevel(6);
        pj.dealDmg(target, 100);
        Assert.assertEquals(950, target.getHealth());
    }
}
