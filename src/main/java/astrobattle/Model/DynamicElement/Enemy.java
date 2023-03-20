package astrobattle.Model.DynamicElement;
import astrobattle.Model.Position;
import astrobattle.View.Sprite.EnemySprite;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Enemy extends Ship implements DynamicElement {
    EnemySprite sprite = new EnemySprite();
    int health = 1000;
    Position pos;
    public Enemy(int x, int y,int colsLen, int rowsLen) {
        super(x, y,colsLen,rowsLen);
        pos = new Position(x,y);
    }

    public int getHealth() {
        return health;
    }

    public void damage(int health) {
        this.health -= health;
    }
    @Override
    public void update(TextGraphics graphics){
        sprite.draw(graphics,getPosition());
    }

    public float getShipSpeed(){
        return  shipSpeed.maxSpeed();
    }

    @Override
    public int getRowLen() {
        return super.getRowLen();
    }
}
