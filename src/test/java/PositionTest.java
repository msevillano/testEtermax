import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

    @Test
    public void testCalculateDistance() {
        Position player1 = new Character();
        Position player2 = new Character();

        Assert.assertEquals(0 , (int) player1.distance(player2));

        player1.setPosition(3,4);

        Assert.assertEquals(5 , (int) player1.distance(player2));
    }
}
