package astrobattle.View.Sprite;

import astrobattle.Model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class EnemySprite extends ElementSprite {
    public void draw(TextGraphics graphics, Position position) {
        graphics.setForegroundColor(TextColor.Factory.fromString(" #ce3514"));
        graphics.drawRectangle(new TerminalPosition(position.getX(), position.getY())
                , new TerminalSize(position.getColLen()
                        , position.getRowLen()),'|');
    }
}
