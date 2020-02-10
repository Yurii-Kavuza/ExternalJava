public class KillerDroid extends Droid
{
	int powerDamage = 10;

	public KillerDroid(int health, int energy, int damage, String name)
	{
		damage += powerDamage;
		super(health, energy, damage, name);
	}

	public int getPowerDamage()
	{
		return powerDamage;
	}

	public void setPowerDamage(int powerDamage)
	{
		this.powerDamage = powerDamage;
	}
}