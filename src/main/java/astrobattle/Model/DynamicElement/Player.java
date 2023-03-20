package astrobattle.Model.DynamicElement;
import astrobattle.Model.Position;
import astrobattle.Model.StaticElement.Asset;
import astrobattle.View.Sprite.PlayerSprite;
import com.googlecode.lanterna.graphics.TextGraphics;


public class Player extends Ship implements  DynamicElement  {
    int health = 1000, score = 0;
    boolean shoot = false;
    PlayerSprite sprite = new PlayerSprite();
    public Player(int x, int y,int cols, int rows){
        super(x,y,cols,rows);
    }
    @Override
    public void update(TextGraphics graphics){
        sprite.draw(graphics,this);
    }
    @Override
    public void move(int direction){
        this.position.move(direction,shipSpeed.maxSpeed());
    }
    public int getHealth(){
        return this.health;
    }
    public void damage(int damage){
        health -=damage;
    }
    public void increaseHealth(int powerup){
        this.health += powerup;
    }
    public int getScore(){
        return score;
    }
    @Override
    public void increaseScore(int score){
        this.score+=score;
    }

}
