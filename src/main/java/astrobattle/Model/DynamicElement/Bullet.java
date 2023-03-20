package astrobattle.Model.DynamicElement;

import astrobattle.Controller.Utilities.Window;
import astrobattle.Model.DynamicElement.Strategy.BulletBehavior;
import astrobattle.Model.DynamicElement.Strategy.FastWeakBullet;
import astrobattle.Model.DynamicElement.Strategy.SlowStrongBullet;
import astrobattle.Model.Element;
import astrobattle.Model.Position;
import astrobattle.View.Sprite.BulletSprite;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Bullet extends Element implements DynamicElement {
    Random random = new Random();
    BulletSprite bulletSprite = new BulletSprite();
    BulletBehavior bulletBehavior = new SlowStrongBullet();

    int power = 2, j = 0, i = 0;
    boolean drawPlayer = false;

    public int getSpeed() {
        return bulletBehavior.speed();
    }
    int speed = 2;
    public Bullet(int x, int y, int cols, int rows) {
        super(x, y, cols, rows);
    }
    public int getPower() {
        return bulletBehavior.strength();

    }

    public void drawPlayer(TextGraphics graphics,Position elementPos){
        if(!drawPlayer)return;
        if(j == 0){
            i  = elementPos.getY();
            j = elementPos.getX() + 1;
        }
        bulletSprite.draw(graphics,j,i);
        this.setPosition(new Position(j,i));
        if(random.nextInt(getSpeed()) == 1){
            i--;
        }
        if(i == 0){
            drawPlayer = false;
            j = 0;
        }
    }
    public void drawEnemy(TextGraphics graphics,Position elementPos){
        if(j == 0){
            i  = elementPos.getY();
            j = elementPos.getX() + 1;
        }
        bulletSprite.draw(graphics,j,i);
        this.setPosition(new Position(j,i));
        if(random.nextInt(getSpeed()) == 1){
            i++;
        }
        if(i == Window.getRows()-1){
            j = 0;
        }
    }
    public void go(){
        drawPlayer = true;
    }

    public BulletBehavior getBulletBehavior() {
        return bulletBehavior;
    }
    public void changeShootingBehaviour(){
        if( getBulletBehavior() instanceof FastWeakBullet){
            setBulletBehavior(new SlowStrongBullet());
            return;
        }
        setBulletBehavior(new FastWeakBullet());
    }

    public void setBulletBehavior(BulletBehavior bulletBehavior) {
        this.bulletBehavior = bulletBehavior;
    }
}
