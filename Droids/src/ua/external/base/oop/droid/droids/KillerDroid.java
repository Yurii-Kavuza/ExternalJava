public class KillerDroid extends Droid
{
	// extra damage to kill another droid
	int extraDamage;

	public KillerDroid(int health, int energy, int damage, String name)
	{
		super(health, energy, damage, name);
	}

	public KillerDroid(Droid victimDroid)
	{
		kill(victimDroid);
	}

	public void kill(Droid victim)
	{
		extraDamage += victim.getHealth();
		this.setDamage(this.getDamage() + extraDamage);

		victim.setHealth(0);
		this.setDamage(this.getDamage() - victim.getHealth());
	}

	public int getExtraDamage()
	{
		return extraDamage;
	}
}
