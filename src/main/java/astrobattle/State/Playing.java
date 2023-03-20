package astrobattle.State;

public class Playing implements State {

    @Override
    public int alert(GameState context) {
        return 1;
    }
}
