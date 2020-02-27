package ua.external.base.oop.droid.droids.droidfactory;

import ua.external.base.oop.droid.droids.DoctorDroid;
import ua.external.base.oop.droid.droids.Droid;

public class DoctorDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new DoctorDroid.Builder(health, energy, damage, name).build();
    }

    public Droid createDroid(int health, int energy, int damage, String name, int criticalLevelOfHealth)
    {
        return new DoctorDroid.Builder(health, energy, damage, name).criticalLevelOfHealth(criticalLevelOfHealth).build();
    }
}
