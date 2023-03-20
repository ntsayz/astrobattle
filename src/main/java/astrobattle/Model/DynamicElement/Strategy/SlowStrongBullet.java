package astrobattle.Model.DynamicElement.Strategy;

public class SlowStrongBullet implements BulletBehavior {

    @Override
    public int strength() {
        return 6;
    }

    @Override
    public int speed() {
        return 2;
    }
}
