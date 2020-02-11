package ua.external.base.oop.droid.droids;

public class DoublePowerDroid extends AthleteDroid{
    public DoublePowerDroid(int health, int energy, int damage, String name) {
        super(health, energy, damage, name);
        super.setMultiplyPower(2);
    }
}
