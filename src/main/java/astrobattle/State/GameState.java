package astrobattle.State;

public class GameState {
    private State currentState;
    public GameState(){
        currentState = new Menu();
    }
    public void setCurrentState(State state){
        currentState = state;
    }
    public int alert(){
        return currentState.alert(this);
    }
    public State getCurrentState(){
        return currentState;
    }
}
