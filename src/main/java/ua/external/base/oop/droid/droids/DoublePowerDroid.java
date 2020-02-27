package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.Flyable;

public class DoublePowerDroid extends AthleteDroid implements Flyable {
    public DoublePowerDroid(int health, int energy, int damage, String name) {
        super(health, energy, damage, name);
        super.setMultiplyPower(2);
    }
}
