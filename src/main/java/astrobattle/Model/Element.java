package astrobattle.Model;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Objects;

public abstract class Element {
    private Position position;
    public Element(int x, int y, int cols, int rows) {
        this.position = new Position(x,y,cols,rows);
    }
    public Position getPosition() {
        return position;
    }
    public int getRowLen(){
        return this.position.getRowLen();
    }
    public int getColLen(){
        return this.position.getColLen();
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return Objects.equals(position, element.position);
    }
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
