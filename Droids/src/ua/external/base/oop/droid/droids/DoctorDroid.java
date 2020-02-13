package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.Repairable;

public class DoctorDroid extends Droid implements Repairable {

	private int criticalLevelOfHealth = 10;

	public DoctorDroid(int health, int energy, int damage, String name)
	{
		super(health, energy, damage, name);
	}

	// This function checks if a droid is healthy or not
	public void medicalExamination(Droid patient)
	{
		// if value of var health of droid patient is lower than critical level
		if(patient.getHealth() <= criticalLevelOfHealth)
		{
			// we treat the patient
			treatPatient(patient);
		}
		else
		{
			// if value of var health of droid patient is higher than critical level
			// we print that our droid is healthy
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
