package astrobattle.Model.DynamicElement.Strategy;

public class FastShip implements ShipSpeed {
    @Override
    public float maxSpeed() {
        return (float) 0.60;
    }
}
