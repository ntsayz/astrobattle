package astrobattle.View.Sprite;

import astrobattle.Model.DynamicElement.Player;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PlayerSprite extends ElementSprite {
    public void draw(TextGraphics graphics, Player player) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#766e6e"));
        graphics.drawRectangle(new TerminalPosition(player.getPosition().getX(), player.getPosition().getY())
                , new TerminalSize(player.getColLen()
                        , player.getRowLen()),'|');
    }
}
