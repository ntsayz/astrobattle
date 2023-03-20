package astrobattle;

import astrobattle.Model.DynamicElement.Enemy;
import astrobattle.Model.Position;
import astrobattle.Model.DynamicElement.Player;
import astrobattle.View.*;
import astrobattle.View.Sprite.*;


import com.googlecode.lanterna.graphics.TextGraphics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class ViewTest {
    Player player;
    Position pos;
    int posj, posi;
    BulletSprite bulletSprite;
    CoinSprite coinSprite;
    EnemySprite enemySprite;
    PlayerSprite playerSprite;
    PowerUpSprite powerUpSprite;
    TextGraphics graphicsmock;
    ArrayList<Enemy> enemies;

    @BeforeEach
    void setup(){
        posj = 2;
        posi =2;
        enemies = new ArrayList<>();
        pos = new Position(2,2,2,2);
        player = new Player(2,2,2,2);
        graphicsmock = Mockito.mock(TextGraphics.class);


        bulletSprite = new BulletSprite();
        coinSprite = new CoinSprite();
        enemySprite = new EnemySprite();
        playerSprite = new PlayerSprite();
        powerUpSprite = new PowerUpSprite();

    }
    @Test
    public void ViewsTest() throws InterruptedException {
        PlayingView.draw(graphicsmock,player,enemies);
        InstructionsView.draw(graphicsmock);
        LostView.draw(graphicsmock);
        ExitView.draw(graphicsmock);
        PauseView.draw(graphicsmock);
        for(int i = 0; i < 3;i++){
            MenuView.draw(graphicsmock,i);
        }
    }
    @Test
    public void SpritesTest() {
        bulletSprite.draw(graphicsmock,posj,posi);
        coinSprite.draw(graphicsmock,pos);
        enemySprite.draw(graphicsmock,pos);
        playerSprite.draw(graphicsmock,player);
        powerUpSprite.draw(graphicsmock,pos);
    }



}
