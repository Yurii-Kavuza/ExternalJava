package ua.external.base.oop.droid.droids.droidfactory;

import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.KillerDroid;

public class KillerDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name) {
        return new KillerDroid(health, energy, damage, name);
    }
}
