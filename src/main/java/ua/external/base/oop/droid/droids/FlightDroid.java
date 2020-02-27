package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageWithoutWeapon;
import ua.external.base.oop.droid.droids.behavior.EnergyUsual;
import ua.external.base.oop.droid.droids.behavior.Flyable;

public class FlightDroid extends Droid implements Flyable
{
	public FlightDroid(int health, int energy, int damage, String name)
	{
		damageBehavior = new DamageWithoutWeapon();
		energyBehavior = new EnergyUsual();
		setEssentialParameters(health,energy,damage,name);
	}

	@Override
	public void startFly() {
		System.out.println("I am flying long distances");
	}
}
