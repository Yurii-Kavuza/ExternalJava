package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageWithoutWeapon;
import ua.external.base.oop.droid.droids.behavior.EnergyUsual;

public class KillerDroid extends Droid
{
	// extra damage to kill another droid
	int extraDamage = 0;

	public KillerDroid(int health, int energy, int damage, String name)
	{
		damageBehavior = new DamageWithoutWeapon();
		energyBehavior = new EnergyUsual();
		setEssentialParameters(health,energy,damage,name);
	}

	public void killEnemy(Droid enemy)
	{
		extraDamage += enemy.getHealth();
		this.modifyDamage(this.performDamage() + extraDamage);
		this.modifyDamage(this.performDamage() - enemy.getHealth());
		enemy.setHealth(0);
	}

	public int getExtraDamage()
	{
		return extraDamage;
	}

	@Override
	public String toString() {return super.toString() + ", extraDamage = " + extraDamage;}
}
