public class KillerDroid extends Droid
{
	int extraDamage;

	public KillerDroid(int health, int energy, int damage, String name)
	{
		damage += extraDamage;
		super(health, energy, damage, name);
	}

	public int getExtraDamage()
	{
		return extraDamage;
	}

	public void setExtraDamage(int extraDamage)
	{
		this.extraDamage = extraDamage;
	}
}