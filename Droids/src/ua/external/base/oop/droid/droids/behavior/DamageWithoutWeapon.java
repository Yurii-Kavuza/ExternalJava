package ua.external.base.oop.droid.droids.behavior;

import java.io.Serializable;

public class DamageWithoutWeapon implements DamageBehavior, Serializable {
    int damage=30;

    public DamageWithoutWeapon() {
    }

    public DamageWithoutWeapon(int damage) {
        this.damage = damage;
    }

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
