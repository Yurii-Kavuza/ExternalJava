package ua.external.base.oop.droid.droids.droidfactory;

import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.SelfHealingDroid;

public class SelfHealingDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new SelfHealingDroid.Builder(health, energy, damage, name).build();
    }

    public Droid createDroid(int health, int energy, int damage, String name, double recoveryRatio)
    {
        return new SelfHealingDroid.Builder(health, energy, damage, name).recoveryRatio(recoveryRatio).build();
    }
}
