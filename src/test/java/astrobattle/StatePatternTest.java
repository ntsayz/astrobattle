package astrobattle;

import astrobattle.Controller.StateController;
import astrobattle.State.*;
import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatePatternTest {
    StateController stateController = new StateController();
    GameState stateContext;
    State currentState;


    @BeforeEach
    void setup() {
        stateController = new StateController();
        stateContext = new GameState();
    }
    @Test
    public void menuState(){
        stateController.processKey(KeyStroke.fromString("<PageDown>"));
        stateController.processKey(KeyStroke.fromString("<PageDown>"));
        stateController.processKey(KeyStroke.fromString("<Return>"));
        assertFalse(stateController.getState() instanceof Menu);
        assertTrue(stateController.getState() instanceof Exit);
    }
    // testing state controller's static list
    @Test
        public void StateStaticListTest(){
        stateController.processKey(KeyStroke.fromString("<PageDown>"));
        stateController.processKey(KeyStroke.fromString("<Return>"));
        assertEquals(1, StateController.getStateWorkaround());
    }

    @Test
    public void statePattern(){
        stateContext.setCurrentState( new Playing());
        assertEquals(stateContext.alert(),1);
        stateContext.setCurrentState( new Instructions());
        assertEquals(stateContext.alert(),2);
        stateContext.setCurrentState( new Menu());
        assertEquals(stateContext.alert(),0);
        stateContext.setCurrentState( new Pause());
        assertEquals(stateContext.alert(),4);
        stateContext.setCurrentState( new Exit());
        assertEquals(stateContext.alert(),3);
        stateContext.setCurrentState( new Lost());
        assertNotEquals(stateContext.alert(),2);

    }

}
