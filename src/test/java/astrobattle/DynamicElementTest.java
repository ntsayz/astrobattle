package astrobattle;

import astrobattle.Model.DynamicElement.DynamicElement;
import astrobattle.Model.DynamicElement.Enemy;
import astrobattle.Model.DynamicElement.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicElementTest {
    Player player;
    DynamicElement p;
    Enemy enemy;

    @BeforeEach
    void setup(){
        p = new Enemy(4,4,4,4);
        player = new Player(2,2,2,2);
        enemy = new Enemy(4,4,4,4);
        assertEquals(player.getHealth(),1000);
        assertEquals(enemy.getHealth(),1000);
    }

    @Test
    public void PlayerTest(){
        player.damage(100);
        assertNotEquals(player.getHealth(),1000);
        player.increaseScore(100);
        assertEquals(player.getScore(),100);
        assertEquals(player.getColLen(),2);
    }

    @Test
    public void EnemyTest(){
        enemy.damage(500);
        assertEquals(enemy.getHealth(),500);
        assertEquals(p, enemy);
    }
}
