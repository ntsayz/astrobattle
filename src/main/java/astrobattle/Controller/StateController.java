package astrobattle.Controller;

import astrobattle.State.*;
import astrobattle.View.ExitView;
import astrobattle.View.InstructionsView;
import astrobattle.View.MenuView;
import astrobattle.State.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.util.ArrayList;

public class StateController {
    private static int state;

    State Menu, Playing, Instructions, Exit,Lost;
    ElementController elementController = new ElementController();

    private static ArrayList<Integer> stateWorkaround; // this should change TODO
    //used this bc wanted to pass a primitive value (int state) by reference to ScreenController
    // It needs to be aware of the current state to define text colors
    private final GameState statecontext;
    @SuppressWarnings("StaticAssignmentInConstructor")
    public StateController(){
        this.statecontext = new GameState();
        state = 0;
        stateWorkaround = new ArrayList<>();
        StateController.stateWorkaround.add(state);
        Menu = new Menu();
        Playing = new Playing();
        Instructions = new Instructions();
        Exit = new Exit();
        Lost = new Lost();
    }
    public void drawScreen(TextGraphics graphics, KeyStroke key) throws InterruptedException, IOException {
        if(statecontext.getCurrentState() instanceof Menu){
            MenuView.draw(graphics,state);
        } else if (statecontext.getCurrentState() instanceof Playing) {
            int d = elementController.manager(graphics,key);
            if(d == 1){state = 0;}
            setStatecontext(key);
        } else if (statecontext.getCurrentState()  instanceof Instructions) {
            InstructionsView.draw(graphics);
        } else {
            ExitView.draw(graphics);
        }
    }

    public boolean processKey(KeyStroke key){
        if(key == null) return true;
        if(statecontext.getCurrentState() instanceof Menu){
            changeState(key);
        }else if(statecontext.getCurrentState() instanceof Instructions){
            if(key.getKeyType() == KeyType.Enter){
                state = 0;
            }
        }else if (statecontext.getCurrentState() instanceof Playing) {
            if(elementController.processKey(key) == 1){
                state = 0;
            }
            elementController.check();
        }
        setStatecontext(key);

        return !(statecontext.getCurrentState() instanceof Exit);
    }


    private void changeState(KeyStroke key){
        if(key == null)return;
        switch (key.getKeyType()){
            case ArrowUp: case PageUp:
                if(state > 0){state--;}
                break;
            case ArrowDown: case PageDown:
                if(state < 2 ){state++;}
                break;
            default:
                break;
        }
    }

    public void setStatecontext(KeyStroke key) {
        if(key == null)return;
        switch (key.getKeyType()){
            case Enter:
                switch (state){
                    case 0:
                        if(statecontext.getCurrentState() instanceof  Instructions || statecontext.getCurrentState() instanceof  Playing){

                            statecontext.setCurrentState(Menu);
                        }else{
                            statecontext.setCurrentState(Playing);
                        }
                        break;
                    case 1: statecontext.setCurrentState(Instructions);break;
                    case 2:statecontext.setCurrentState(Exit);break;
                    default:
                        return;
                }
            break;
            case EOF :statecontext.setCurrentState(Exit);break;
            case Escape:statecontext.setCurrentState(Menu);break;
            default:
                break;
        }
    }
    public static int getStateWorkaround(){
        stateWorkaround.clear();
        stateWorkaround.add(state);
        return stateWorkaround.get(0);
    }
    public State getState(){
        return statecontext.getCurrentState();
    }


}
