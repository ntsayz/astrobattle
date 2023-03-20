package astrobattle.View.Sprite;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BulletSprite extends ElementSprite{

    public void draw(TextGraphics graphics,int j,int i) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.drawRectangle(new TerminalPosition(j,i)
                , new TerminalSize(2, 2),'|');
    }
}//
