package ua.external.base.oop.droid.droids.behavior;

public class DamageWithoutWeapon implements DamageBehavior {
    int damage=30;

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage() {
        this.damage=30;
    }

    public void setDamage(int value) {
        this.damage=value;
    }
}
