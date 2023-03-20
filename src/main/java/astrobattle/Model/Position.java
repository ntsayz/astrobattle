package astrobattle.Model;

import astrobattle.Controller.Utilities.Window;

import java.util.Objects;

public class Position {
    private int x,rowLen,colLen;
    private int y;
    int winCols =Window.getCols() , winRows = Window.getRows();

    private double velocityX,velocityY, accX, accY;
    private double dAcc = 0.8, FRICTION_COEF = 0.4f;

    public void move(int direction,float maxSpeed){
        if(maxSpeed > 90){
            dAcc = 0.01;
        }
        switch (direction){
            case 1 : this.accY -= dAcc;break; //UP
            case 2 : this.accY += dAcc;break; //DOWN
            case 3 :this.accX -= dAcc;break;//LEFT
            case 4 :this.accX += dAcc; break;//RIGHT
        }
        windowBound();
        // O.15 slow
        if(Math.abs(velocityY) > maxSpeed || Math.abs(velocityX) > maxSpeed){

        }else{
            velocityX+= accX;
            velocityY+= accY;
        }



        velocityY -= (FRICTION_COEF * velocityY);
        velocityX -=(FRICTION_COEF * velocityX);


        this.x += (int) velocityX;
        this.y += (int) velocityY;

    }
    private void windowBound(){
        if(this.x < 0){
            this.x = 0;
            this.velocityX *=-1;
            this.accX = 0;
        }
        else if(this.x > winCols - this.colLen){
            this.x = winCols- colLen;
            this.velocityX *=-1;
            this.accX = 0;
        }
        if(this.y < 0){
            this.y = 0;
            this.velocityY *=-1;
            this.accY = 0;
        } else if (this.y > winRows - this.rowLen) {
            this.y = winRows - rowLen;
            this.velocityY *= -1;
            this.accY= 0;
        }
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Position(int x, int y, int colLen, int rowLen){
        this.x = x;
        this.y = y;
        this.colLen = colLen;
        this.rowLen = rowLen;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int xv) {
        this.x = xv;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position obj = (Position) o;
        return this.x + this.colLen >= obj.x && this.x <= obj.x + this.colLen &&
                this.y + this.rowLen >= obj.y && this.y <= obj.y + obj.rowLen;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    public int getRowLen() {
        return this.rowLen;
    }

    public int getColLen() {
        return this.colLen;
    }
}
