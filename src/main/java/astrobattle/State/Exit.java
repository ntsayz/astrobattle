package astrobattle.State;

public class Exit implements State {
    @Override
    public int alert(GameState context) {
        return 3;
    }
}
