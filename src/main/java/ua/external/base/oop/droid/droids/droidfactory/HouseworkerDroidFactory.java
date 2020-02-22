package ua.external.base.oop.droid.droids.droidfactory;

import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.HouseworkerDroid;

public class HouseworkerDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name) {
        return new HouseworkerDroid(health, energy, damage, name);
    }

    public Droid createDroid(int health, int energy, int damage, String name,String responsibility ) {
        return new HouseworkerDroid(health, energy, damage, name, responsibility);
    }
}
