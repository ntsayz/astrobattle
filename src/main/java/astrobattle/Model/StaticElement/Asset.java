package astrobattle.Model.StaticElement;

import astrobattle.Model.Element;
import com.googlecode.lanterna.graphics.TextGraphics;

public  abstract class Asset extends Element {

    public Asset(int x, int y, int cols, int cols1) {
        super(x,y,cols,cols1);
    }

    public void update(TextGraphics graphics){}
}
