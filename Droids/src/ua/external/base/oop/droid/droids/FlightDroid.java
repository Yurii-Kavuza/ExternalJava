package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageWithoutWeapon;
import ua.external.base.oop.droid.droids.behavior.EnergyUsual;

public class FlightDroid extends Droid
{
	public FlightDroid(int health, int energy, int damage, String name)
	{
		damageBehavior = new DamageWithoutWeapon();
		energyBehavior = new EnergyUsual();
		setEssentialParameters(health,energy,damage,name);
	}

	public void fly()
	{
		System.out.println("I am flying!");
	}
}
