package ua.external.base.oop.droid.droids.droidfactory;

import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.HouseworkerDroid;
import ua.external.base.oop.droid.droids.behavior.DamageBehavior;
import ua.external.base.oop.droid.droids.behavior.NoDamage;
import ua.external.base.oop.droid.droids.behavior.NoEnergy;

public class HouseworkerDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name) {
        return new HouseworkerDroid.Builder(health, energy, damage, name).build();
    }

    public Droid createDroid(int health, int energy, int damage, String name, String responsibility ) {
        return new HouseworkerDroid.Builder(health, energy, damage, name).responsibility(responsibility).build();
    }
}
