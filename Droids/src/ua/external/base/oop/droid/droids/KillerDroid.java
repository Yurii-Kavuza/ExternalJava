package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageWithoutWeapon;
import ua.external.base.oop.droid.droids.behavior.EnergyUsual;

public class KillerDroid extends Droid
{
	// extra damage to kill another droid
	int extraDamage;

	public KillerDroid(int health, int energy, int damage, String name)
	{
		damageBehavior = new DamageWithoutWeapon();
		energyBehavior = new EnergyUsual();
		this.setHealth(health);
		this.setName(name);
		this.damageBehavior.setDamage(damage);
		this.energyBehavior.setEnergy(energy);
	}

	public void killEnemy(Droid enemy)
	{
		extraDamage += enemy.getHealth();
		this.damageBehavior.setDamage(this.damageBehavior.getDamage() + extraDamage);

		enemy.setHealth(0);
		this.damageBehavior.setDamage(this.damageBehavior.getDamage() - enemy.getHealth());
	}

	public int getExtraDamage()
	{
		return extraDamage;
	}
}
