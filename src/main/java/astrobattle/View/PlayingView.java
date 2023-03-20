
package astrobattle.View;

import astrobattle.Controller.Utilities.Window;
import astrobattle.Model.DynamicElement.Enemy;
import astrobattle.Model.DynamicElement.Player;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class PlayingView implements View{
    static int bars,enemybars =1;
    static String red = "#f20c0c";
    static String grey = "#766e6e";
    static String white = "#ffffff";
    static String green = "#12ee19";
    static String color = green;

    public static void draw(TextGraphics graphics, Player player, ArrayList<Enemy> enemies) {
        graphics.setForegroundColor(TextColor.Factory.fromString(grey));
        graphics.putString(new TerminalPosition(Window.getCols() -20  , 2), "HEALTH");
        graphics.putString(new TerminalPosition(Window.getCols() -20  , 4), "SCORE");
        graphics.putString(new TerminalPosition(Window.getCols() - 10  , 4), Integer.toString(player.getScore()));

        bars = player.getHealth()/100;
        color = green;
        if(bars < 3){
            color = red;
        }else{
            color = green;
        }
        for(int i =0; i < bars; i++){
            graphics.setForegroundColor(TextColor.Factory.fromString(color));
            graphics.putString(new TerminalPosition(Window.getCols() -12 + i  , 2), "|");
        }

        int j = 1;
        for(Enemy enemy:enemies){
            enemybars = enemy.getHealth()/100;
            for(int i =0; i < enemybars; i++){
                graphics.setForegroundColor(TextColor.Factory.fromString(red));
                graphics.putString(new TerminalPosition(2 + i  , 1+j*2), "|");
            }
            j++;
        }

    }
}
