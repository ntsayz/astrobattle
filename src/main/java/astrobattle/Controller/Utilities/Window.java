package astrobattle.Controller.Utilities;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Window{
    static int rows, cols;
    @SuppressWarnings("StaticAssignmentInConstructor")
    public Window(int x, int y){
        Window.rows = y;
        Window.cols = x;
    }
    public static int getRows() {
        return rows;
    }
    public static int getCols() {
        return cols;
    }

    public static void setRows(int rows) {
        Window.rows = rows;
    }

    public static void setCols(int cols) {
        Window.cols = cols;
    }

    public static void setBGColor(TextGraphics graphics, String hexcode){
        graphics.setBackgroundColor(TextColor.Factory.fromString(hexcode));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(cols, rows), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString(hexcode));
    }
}
