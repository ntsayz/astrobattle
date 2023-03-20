package astrobattle;

import astrobattle.Controller.ApplicationController;
import astrobattle.Controller.StateController;
import astrobattle.Controller.Utilities.Window;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;


public class ApplicationControllerTest {

    Window window;
    Screen screen;
    StateController stateController;
    TextGraphics graphics;
    ApplicationController app;
    KeyStroke key;
    @BeforeEach
    void setup() throws IOException{
        window = Mockito.mock(Window.class);
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);
        stateController = Mockito.mock(StateController.class);


        app = new ApplicationController(window,screen,stateController);
        app.setGraphics(graphics);
        app.setScreen(screen);
        app.setWindow(window);
        app.setStateController(stateController);
    }

    @Test
    public void StateControllerCallTest() throws IOException, InterruptedException {
        app.run();
        Mockito.verify(stateController,Mockito.times(1)).drawScreen(graphics,key);
        Mockito.verify(stateController,Mockito.times(1)).processKey(key);
    }
}
