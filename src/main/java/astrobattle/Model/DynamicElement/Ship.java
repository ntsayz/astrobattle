package astrobattle.Model.DynamicElement;

import astrobattle.Model.DynamicElement.Strategy.BulletBehavior;
import astrobattle.Model.DynamicElement.Strategy.ShipSpeed;
import astrobattle.Model.DynamicElement.Strategy.SlowShip;
import astrobattle.Model.DynamicElement.Strategy.SlowStrongBullet;
import astrobattle.Model.Element;
import astrobattle.Model.Position;
import astrobattle.Model.StaticElement.Asset;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Ship extends Element implements  DynamicElement {
    BulletBehavior bulletBehavior = new SlowStrongBullet();
    ShipSpeed shipSpeed = new SlowShip();
    Position position;

    Ship(int x, int y,int cols,int rows){
        super(x,y,cols,rows);
        this.position = new Position(x,y,cols,rows);
    }
    public void increaseScore(int score){}

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setShipSpeed(ShipSpeed shipSpeed){
        this.shipSpeed = shipSpeed;
    }


    public void update(TextGraphics graphics){

    }
    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getColLen() {
        return super.getColLen();
    }

    @Override
    public int getRowLen() {
        return super.getRowLen();
    }

    public void move(int direction){
        this.position.move(direction,shipSpeed.maxSpeed());
    }
    @SuppressWarnings("NonOverridingEquals")
    public boolean equals(Asset el) {
        return this.position.equals(el.getPosition());
    }


}

