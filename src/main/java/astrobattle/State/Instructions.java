package astrobattle.State;

public class Instructions implements State {
    @Override
    public int alert(GameState context) {
        return 2;
    }
}
