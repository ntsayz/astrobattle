package astrobattle.View.Sprite;

import astrobattle.Model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class CoinSprite extends ElementSprite {
    public void draw(TextGraphics graphics, Position position) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#cff10c"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "o");
    }
}
