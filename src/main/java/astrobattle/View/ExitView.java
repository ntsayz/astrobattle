package astrobattle.View;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ExitView implements View{

    public static void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.putString(new TerminalPosition(25, 25), "Bye");
    }
}
