package astrobattle.View;

import astrobattle.Controller.Utilities.Window;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class LostView implements View {
    static String red = "#f20c0c";
    static String color = red;
    static boolean change = false;
    static String grey = "#766e6e";
    public static void draw(TextGraphics graphics) throws InterruptedException {
        if(change){
            change = false;
            color =red;
        }else{
            change = true;
            color = grey;
        }
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(new TerminalPosition(Window.getCols()/2 -7 , Window.getRows()/2), "Y O U   L O S T");
        graphics.setForegroundColor(TextColor.Factory.fromString(grey));
        graphics.putString(new TerminalPosition(Window.getCols()/2 -27 , Window.getRows()/2+2), "Press [ESC] to go back to Menu or any key to play again");
        Thread.sleep(100);
    }
}
