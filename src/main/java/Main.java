
import astrobattle.Controller.*;
import astrobattle.Controller.StateController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import astrobattle.Controller.Utilities.Window;


import java.io.IOException;
@SuppressWarnings("DefaultPackage")
public class Main {
    public static void main(String[] args) throws IOException {
        Window window = new Window(150,50);
        TerminalSize terminalSize = new TerminalSize(Window.getCols(), Window.getRows());
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        Screen screen = new TerminalScreen(terminal);
        StateController stateController = new StateController();
        ApplicationController app = new ApplicationController(window,screen,stateController);

        app.run();

    }
}

// TerminalSize terminalSize;
//    DefaultTerminalFactory terminalFactory;
// Window win,TerminalSize terminalSize,DefaultTerminalFactory terminalFactory,Terminal terminal