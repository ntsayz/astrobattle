package astrobattle.View.Sprite;

import astrobattle.Model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;

import com.googlecode.lanterna.graphics.TextGraphics;

public class PowerUpSprite extends ElementSprite {
    public void draw(TextGraphics graphics, Position position) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#12ee19"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "o");
    }
}
