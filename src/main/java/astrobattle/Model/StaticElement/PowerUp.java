package astrobattle.Model.StaticElement;

import astrobattle.View.Sprite.PowerUpSprite;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PowerUp extends Asset{
    PowerUpSprite sprite = new PowerUpSprite();
    public PowerUp(int x, int y, int row, int col){
        super(x,y,row,col);
    }
    @Override
    public void update(TextGraphics graphics){
        sprite.draw(graphics,getPosition());
    }
}
