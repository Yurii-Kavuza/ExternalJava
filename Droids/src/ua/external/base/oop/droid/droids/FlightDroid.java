package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageWithoutWeapon;
import ua.external.base.oop.droid.droids.behavior.EnergyUsual;

public class FlightDroid extends Droid
{
	public FlightDroid(int health, int energy, int damage, String name)
	{
		damageBehavior = new DamageWithoutWeapon();
		energyBehavior = new EnergyUsual();
		this.setHealth(health);
		this.setName(name);
		this.damageBehavior.setDamage(damage);
		this.energyBehavior.setEnergy(energy);
	}

	public void fly()
	{
		System.out.println("I can fly!");
	}
}
