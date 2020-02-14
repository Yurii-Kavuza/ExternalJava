package ua.external.base.oop.droid.droids.droidfactory;

import ua.external.base.oop.droid.droids.Droid;

public interface DroidFactory
{
    Droid createDroid(int health, int energy, int damage, String name);
}
