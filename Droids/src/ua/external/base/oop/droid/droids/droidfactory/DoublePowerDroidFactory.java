package ua.external.base.oop.droid.droids.droidfactory;

import ua.external.base.oop.droid.droids.DoublePowerDroid;
import ua.external.base.oop.droid.droids.Droid;

public class DoublePowerDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new DoublePowerDroid(health, energy, damage, name);
    }
}
