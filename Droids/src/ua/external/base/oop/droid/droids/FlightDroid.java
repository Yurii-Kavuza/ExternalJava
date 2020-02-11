public class FlightDroid extends Droid
{
	public FlightDroid(int health, int energy, int damage, String name)
	{
		super(health, energy, damage, name);
	}

	public void fly()
	{
		System.out.println("I can fly!");
	}
}
