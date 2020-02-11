package ua.external.base.oop.droid.droids;

public class KillerDroid extends Droid
{
	// extra damage to kill another droid
	int extraDamage;

	public KillerDroid(int health, int energy, int damage, String name)
	{
		super(health, energy, damage, name);
	}

	public void killEnemy(Droid enemy)
	{
		extraDamage += enemy.getHealth();
		this.setDamage(this.getDamage() + extraDamage);

		enemy.setHealth(0);
		this.setDamage(this.getDamage() - enemy.getHealth());
	}

	public int getExtraDamage()
	{
		return extraDamage;
	}
}
