package ua.external.base.oop.droid.droids;

public class DoublePowerDroid extends Droid{
    public DoublePowerDroid(int energy, int damage, int health) {
        super(energy, damage * 2, health);
    }
}
