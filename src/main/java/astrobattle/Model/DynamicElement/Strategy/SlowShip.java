package astrobattle.Model.DynamicElement.Strategy;

public class SlowShip implements ShipSpeed {
    @Override
    public float maxSpeed() {
        return (float) 0.15;
    }
}
