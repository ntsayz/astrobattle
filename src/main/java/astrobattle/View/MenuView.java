package astrobattle.View;

import astrobattle.Controller.StateController;
import astrobattle.Controller.Utilities.Window;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MenuView implements View{

    public static void draw(TextGraphics graphics, int state) {
        String play = "#766e6e", istr = "#766e6e",exit = "#766e6e", red ="#f20c0c";
        switch(state){
            case 0:
                play = red;
            break;
            case 1:
                istr = red;
            break;
            case 2:
                exit = red;
            break;
        }
        drawLogo(graphics);
        // TODO : use Window instance to set rows
        graphics.setForegroundColor(TextColor.Factory.fromString(play));
        graphics.putString(new TerminalPosition(Window.getCols()/2, 20), "PLAY");
        graphics.setForegroundColor(TextColor.Factory.fromString(istr));
        graphics.putString(new TerminalPosition((Window.getCols()/2) -3, 30), "INSTRUCTIONS");
        graphics.setForegroundColor(TextColor.Factory.fromString(exit));
        graphics.putString(new TerminalPosition(Window.getCols()/2, 40), "EXIT");

        graphics.setForegroundColor(TextColor.Factory.fromString("#3e3837"));
        graphics.putString(new TerminalPosition(Window.getCols()-23 , Window.getRows()-3), "[ARROW UP] Navigation");
        graphics.putString(new TerminalPosition(Window.getCols()-23 , Window.getRows()-2), "[ARROW DOWN] Navigation");
        graphics.putString(new TerminalPosition(Window.getCols()-23 , Window.getRows()-1), "[ENTER] Select");

    }
    public static void drawLogo(TextGraphics graphics){
        // A
        graphics.setForegroundColor(TextColor.Factory.fromString("#766e6e"));
        graphics.putString(new TerminalPosition(Window.getCols()/2 - 8, Window.getRows()-38), "A S T R O");
        graphics.fillRectangle(new TerminalPosition(68,5),new TerminalSize(3,6), '|');
        graphics.fillRectangle(new TerminalPosition(71,5),new TerminalSize(3,1), '|');
        graphics.fillRectangle(new TerminalPosition(74,5),new TerminalSize(3,6), '|');
        graphics.fillRectangle(new TerminalPosition(75,5),new TerminalSize(2,6), '|');
        graphics.fillRectangle(new TerminalPosition(71,8),new TerminalSize(4,1), '|');


        graphics.setForegroundColor(TextColor.Factory.fromString("#f20c0c"));
        graphics.putString(new TerminalPosition(Window.getCols()/2 + 3, Window.getRows()-38), "B A T T L E");
        graphics.fillRectangle(new TerminalPosition(78,5),new TerminalSize(9,1), '|');
        graphics.fillRectangle(new TerminalPosition(85,5),new TerminalSize(3,6), '|');
        graphics.fillRectangle(new TerminalPosition(78,5),new TerminalSize(3,6), '|');
        graphics.fillRectangle(new TerminalPosition(78,10),new TerminalSize(9,1), '|');
        graphics.fillRectangle(new TerminalPosition(78,7),new TerminalSize(9,1), '|');

    }
}
