package astrobattle;

import astrobattle.Controller.ElementController;
import astrobattle.Model.DynamicElement.Bullet;
import astrobattle.Model.DynamicElement.Enemy;
import astrobattle.Model.DynamicElement.Player;
import astrobattle.Model.Position;
import astrobattle.Model.StaticElement.Coin;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.BeforeEach;
import astrobattle.Model.StaticElement.Asset;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ElementControllerTest {
    ElementController elementController  = new ElementController();
    Player playerMock;
    Enemy enemy1 , enemy2, enemy3, enemy4;
    Coin coin1,coin2;
    Position position;
    ArrayList<Asset> assets;
    TextGraphics graphics;
    KeyStroke key;
    Bullet playerBullet, enemyBullet;
    ArrayList<Enemy> enemies;
    @BeforeEach
    void setUp(){
        ElementController elementController = new ElementController();
        position = new Position(2,2,2,5);
        //Setting Player
        playerMock= Mockito.mock(Player.class);
        elementController.setPlayer(playerMock);
        //Setting Assets
        assets = new ArrayList<>();
        enemies = new ArrayList<>();
        coin1 = new Coin( 2,  2,1,1);
        coin2 = new Coin( 2,  3,1,1);
        assets.add(coin1);
        assets.add(coin2);
        elementController.setAssets(assets);
        assertEquals(elementController.getAssets().size(),2);
    }

    @Test
    public void removeCoinFromScreenTest(){
        elementController.setAssets(assets);
        Mockito.when(playerMock.equals(coin1)).thenReturn(true);
        elementController.retrieveAssets(1);
        assertEquals(elementController.getAssets().size(),1);
    }

    @Test
    public void ElementResetTest(){
        int playerInitialRowLength =1;
        elementController.reset();
        elementController.check();
        assertNotEquals(playerInitialRowLength,elementController.getPlayer().getRowLen());
    }


    // CREATE MULTIPLE SCENARIOS TO COVER THE MOST POSSIBLE CASES
    @Test
    public void ManagerTest() throws InterruptedException {
        assets.clear();
        playerMock= Mockito.mock(Player.class);
        Mockito.when(playerMock.getPosition()).thenReturn(new Position(2,2,2,2));
        playerBullet = Mockito.mock(Bullet.class);
        Mockito.when(playerBullet.getPosition()).thenReturn(new Position(2,2,2,2));
        enemyBullet = Mockito.mock(Bullet.class);
        Mockito.when(enemyBullet.getPosition()).thenReturn(new Position(2,2,2,2));
        enemy1 = Mockito.mock(Enemy.class);
        Mockito.when(enemy1.getPosition()).thenReturn(new Position(2,2,2,2));
        enemies.add(enemy1);
        assets.add(coin1);
        graphics = Mockito.mock(TextGraphics.class);

        elementController.setPlayer(playerMock);
        elementController.setEnemies(enemies);
        elementController.setPlayerBullet(playerBullet);
        elementController.setEnemyBullet(enemyBullet);
        elementController.setAssets(assets);

        elementController.manager(graphics,key);

    }
}
