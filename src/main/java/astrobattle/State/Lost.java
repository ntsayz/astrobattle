package astrobattle.State;

public class Lost implements State{
    @Override
    public int alert(GameState context) {
        return 5;
    }
}
