package astrobattle;

import astrobattle.Model.DynamicElement.Bullet;
import astrobattle.Model.DynamicElement.Enemy;
import astrobattle.Model.DynamicElement.Strategy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyPatternTest {
    Bullet bullet;
    Enemy ship;
    ShipSpeed shipSpeed;
    BulletBehavior bulletBehavior;

    @BeforeEach
    public void setup(){
        bullet = new Bullet(2,2,2,2);
        bulletBehavior = new FastWeakBullet();
        bullet.setBulletBehavior(bulletBehavior);

        ship = new Enemy(2,2,2,2);
        shipSpeed = new SuperSlowShip();
        ship.setShipSpeed(new SuperSlowShip());

    }


    @Test
    public void BulletBehaviourTest(){
        assertEquals(bullet.getPower(),2);
        assertEquals(bullet.getSpeed(),6);
        bullet.changeShootingBehaviour();
        assertNotEquals(bullet.getPower(),2);
        assertEquals(bullet.getSpeed(),2);
    }

    @Test
    public void ShipBehaviourTest(){
        assertEquals(ship.getShipSpeed(),100);
        ship.setShipSpeed(new SlowShip());
        assertEquals(ship.getShipSpeed(),(float) 0.15);
        ship.setShipSpeed(new FastShip());
        assertNotEquals(ship.getShipSpeed(),(float) 0.15);
        assertEquals(ship.getShipSpeed(),(float) 0.60);

    }

}
