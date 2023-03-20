package astrobattle.Model.DynamicElement.Strategy;

public class SuperSlowShip implements ShipSpeed{
    @Override
    public float maxSpeed() {
        return (float) 100;
    }
}
