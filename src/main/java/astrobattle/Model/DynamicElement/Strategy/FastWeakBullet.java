package astrobattle.Model.DynamicElement.Strategy;

public class FastWeakBullet implements BulletBehavior {
    @Override
    public int strength() {
        return 2;
    }
    @Override
    public int speed() {return 6;}
}
