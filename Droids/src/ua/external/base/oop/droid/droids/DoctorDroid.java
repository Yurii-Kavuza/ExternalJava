package ua.external.base.oop.droid.droids;

public class DoctorDroid extends Droid
{
	private int criticalLevelOfHealth = 10;


	public DoctorDroid(int health, int energy, int damage, String name)
	{
		super(health, energy, damage, name);
	}

	public DoctorDroid(Droid patient)
	{
		medicalExamination(patient);
	}


	public void medicalExamination(Droid patient)
	{
		if(patient.getHealth() <= criticalLevelOfHealth)
		{
			treatPatient(patient);
		}
		else
		{
			System.out.println("You are healthy! :)");
		}
	}

	public void treatPatient(Droid patient)
	{
		setHealth(patient.getHealth() * 2);
	}


	public int getCriticalLevelOfHealth()
	{
		return criticalLevelOfHealth;
	}

	public void setCriticalLevelOfHealth(int criticalLevelOfHealth)
	{
		this.criticalLevelOfHealth = criticalLevelOfHealth;
	}
}
