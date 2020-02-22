package ua.external.base.oop.droid.droids.droidfactory;

import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.FlightDroid;

public class FlightDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new FlightDroid(health, energy, damage, name);
    }
}
