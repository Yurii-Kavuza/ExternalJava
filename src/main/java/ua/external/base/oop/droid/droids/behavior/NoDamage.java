package ua.external.base.oop.droid.droids.behavior;

import java.io.Serializable;

public class NoDamage implements DamageBehavior, Serializable {
    int damage=0;

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage() {
        this.damage=0;
    }

    public void setDamage(int value){
        this.setDamage();
    }
}
