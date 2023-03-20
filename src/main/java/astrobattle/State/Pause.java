package astrobattle.State;

public class Pause implements State {
    @Override
    public int alert(GameState context) {
        return 4;
    }
}
