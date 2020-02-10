public class SelfTreatingDroid extends Droid 
{

	private int treatmentPoints = 5;

	public SelfTreatingDroid(int health, int energy, int damage, String name)
	{
		super(health, energy, damage, name);
	}

	public void selfTreating()
	{
		if(this.getHealth < 10 && treatmentPoints > 0)
		{
			this.getHealth += 5;
			treatmentPoints--;
		}
		if(treatmentPoints <= 0)
		{
			System.out.println("SelfTreatingDroid is not already able to treat himsef!");
		}
	}

	public void int GetTreatmentPoints()
	{
		return treatmentPoints;
	}

	public void setTreatmentPoints(int treatmentPoints)
	{
		this.treatmentPoints = treatmentPoints;
	}
}