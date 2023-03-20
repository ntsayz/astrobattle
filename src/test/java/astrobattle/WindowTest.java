package astrobattle;

import astrobattle.Controller.Utilities.Window;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {

    TextGraphics graphicsmock;
    String hexcode;

    @BeforeEach
    public void setUp(){
        graphicsmock = Mockito.mock(TextGraphics.class);
        Window.setRows(2);
        Window.setCols(2);
        hexcode = "#ffffff";
    }

    @Test
    public void changeSizeTest(){
        assertEquals(Window.getCols(),2);
        Window.setCols(5);
        assertNotEquals(Window.getCols(),2);
        assertEquals(Window.getCols(),5);
    }

    @Test
    public void changeColorTest(){
        Window.setBGColor(graphicsmock,hexcode);
        Mockito.verify(graphicsmock,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(hexcode));
        Mockito.verify(graphicsmock,Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(Window.getRows(), Window.getCols()), ' ');
        Mockito.verify(graphicsmock,Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(hexcode));
    }
}
