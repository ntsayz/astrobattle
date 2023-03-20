package astrobattle.Model.StaticElement;

import astrobattle.View.Sprite.CoinSprite;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Asset{


    CoinSprite sprite = new CoinSprite();

    public Coin(int x, int y,int cols, int rows){
        super(x,y,cols,rows);
    }
    @Override
    public void update(TextGraphics graphics){
        sprite.draw(graphics,getPosition());
    }
}
