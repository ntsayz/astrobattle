package astrobattle.View;

import astrobattle.Controller.Utilities.Window;

import astrobattle.Model.DynamicElement.Player;
import astrobattle.Model.Position;
import astrobattle.View.Sprite.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class InstructionsView implements View{

    static PlayerSprite playerSprite = new PlayerSprite();
    static EnemySprite enemySprite = new EnemySprite();
    static PowerUpSprite powerUpSprite = new PowerUpSprite();
    static CoinSprite coinSprite = new CoinSprite();
    static BulletSprite bulletSprite = new BulletSprite();

    public static void draw(TextGraphics graphics) {

        playerSprite.draw(graphics,new Player(10,38,4,4));
        enemySprite.draw(graphics,new Position(30,38,4,4));
        graphics.setForegroundColor(TextColor.Factory.fromString("#766e6e"));
        graphics.putString(new TerminalPosition(17,32), "S H I P S");
        graphics.putString(new TerminalPosition(15,16), "B U L L E T S");
        graphics.putString(new TerminalPosition(6,43), "P L A Y E R");
        graphics.setForegroundColor(TextColor.Factory.fromString("#ce3514"));
        graphics.putString(new TerminalPosition(28,43), "E N E M Y");
        bulletSprite.draw(graphics,11,21);
        bulletSprite.draw(graphics,31,24);
        graphics.setForegroundColor(TextColor.Factory.fromString("#766e6e"));
        graphics.putString(new TerminalPosition(8,24), "FASTER");
        graphics.putString(new TerminalPosition(6,25), "- DAMAGE");
        graphics.putString(new TerminalPosition(28,27), "SLOWER");
        graphics.putString(new TerminalPosition(26,28), "+ DAMAGE");


        graphics.putString(new TerminalPosition(116,32), "P O W E R  U P S");

        graphics.putString(new TerminalPosition(119,16), "C O I N S");
        graphics.setForegroundColor(TextColor.Factory.fromString("#cff10c"));
        graphics.putString(new TerminalPosition(123,20), "o");
        graphics.putString(new TerminalPosition(120,21), "o");
        graphics.putString(new TerminalPosition(125,22), "o");
        graphics.putString(new TerminalPosition(122,24), "o");

        graphics.setForegroundColor(TextColor.Factory.fromString("#12ee19"));
        graphics.putString(new TerminalPosition(125,36), "o");
        graphics.putString(new TerminalPosition(122,40), "o");

        graphics.setForegroundColor(TextColor.Factory.fromString("#3e3837"));
        graphics.putString(new TerminalPosition(119,17), "+1 POINT");
        graphics.putString(new TerminalPosition(120,33), "+ HEALTH");



        graphics.setForegroundColor(TextColor.Factory.fromString("#766e6e"));
        graphics.putString(new TerminalPosition(Window.getCols()/2 -9 , Window.getRows()-31), "[ARROW UP] MOVE UP");
        graphics.putString(new TerminalPosition(Window.getCols()/2 - 11 , Window.getRows()-29), "[ARROW DOWN] MOVE DOWN");
        graphics.putString(new TerminalPosition(Window.getCols()/2 -11 , Window.getRows()-27), "[ARROW LEFT] MOVE LEFT");
        graphics.putString(new TerminalPosition(Window.getCols()/2 -12 , Window.getRows()-25), "[ARROW RIGHT] MOVE RIGHT");
        graphics.putString(new TerminalPosition(Window.getCols()/2 -6 , Window.getRows()-23), "[TAB] SHOOT");
        graphics.putString(new TerminalPosition(Window.getCols()/2 -13 , Window.getRows()-21), "[ENTER] CHANGE BULLET TYPE");
        graphics.putString(new TerminalPosition(Window.getCols()/2 -9 , Window.getRows()-19), "[ESCAPE] PAUSE/BACK");


        graphics.setForegroundColor(TextColor.Factory.fromString("#f20c0c"));
        graphics.putString(new TerminalPosition(Window.getCols()/2 -28 , Window.getRows()-40), "D E S T R O Y");
        graphics.setForegroundColor(TextColor.Factory.fromString("#766e6e"));
        graphics.putString(new TerminalPosition(Window.getCols()/2 -14 , Window.getRows()-40), " A S  M A N Y  S H I P S  A S  Y O U  C A N");
        graphics.putString(new TerminalPosition(Window.getCols()/2 -12 , Window.getRows()-38), "A N D");
        graphics.setForegroundColor(TextColor.Factory.fromString("#f20c0c"));
        graphics.putString(new TerminalPosition(Window.getCols()/2 - 6, Window.getRows()-38), " D O  N O T  D I E");


        graphics.putString(new TerminalPosition((Window.getCols()/2) - 7, Window.getRows()-3), "RETURN TO MENU");
    }
}
