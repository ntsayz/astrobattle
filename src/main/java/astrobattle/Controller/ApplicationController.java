
package astrobattle.Controller;
import astrobattle.Controller.Utilities.Window;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;


import java.io.IOException;

public class ApplicationController {
    Screen screen;
    TextGraphics graphics;
    StateController stateController;
    Window window;
    KeyStroke key;
    boolean cont;
    static long start = 0;

    public ApplicationController(Window win, Screen screen,StateController stateController) throws IOException {
        this.window = win;
        this.screen = screen;
        this.graphics = screen.newTextGraphics();
        screen.startScreen();
        this.stateController = stateController;
    }

    public void run() throws IOException {
        cont = true;
        while (cont){
            try {
                key = screen.pollInput();
                stateController.drawScreen(this.graphics,key);
                screen.refresh();
                framerate(120);
                Thread.sleep(1);
                cont = stateController.processKey(key);
                processKey(key);
                screen.clear();

            } catch (IOException e) {
                e.printStackTrace();
                screen.close();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        screen.close();
    }
    private void processKey(KeyStroke key) throws IOException {
        if(key == null) return;
        switch (key.getKeyType()) {
            case EOF:screen.close();break;
            default:
                break;
        }

    }
    private static void framerate(int fps) throws InterruptedException {
        long diff, wait;
        wait = 1 / fps;
        diff = System.currentTimeMillis()  - start;
        if (diff < wait) {
            Thread.sleep(wait - diff);
        }
        start = System.currentTimeMillis();
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStateController(StateController stateController) {
        this.stateController = stateController;
    }

    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public void setWindow(Window window) {
        this.window = window;
    }


}
