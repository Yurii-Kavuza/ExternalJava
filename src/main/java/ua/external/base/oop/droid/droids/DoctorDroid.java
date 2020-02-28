package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageWithoutWeapon;
import ua.external.base.oop.droid.droids.behavior.EnergyUsual;
import ua.external.base.oop.droid.droids.behavior.Repairable;

public class DoctorDroid extends Droid implements Repairable {

	private int criticalLevelOfHealth = 10;

	public DoctorDroid(int health, int energy, int damage, String name)
	{
		damageBehavior = new DamageWithoutWeapon();
		energyBehavior = new EnergyUsual();
		setEssentialParameters(health,energy,damage,name);
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
		patient.setHealth(patient.getHealth() * 2);
	}

	public int getCriticalLevelOfHealth()
	{
		return criticalLevelOfHealth;
	}

	public void setCriticalLevelOfHealth(int criticalLevelOfHealth)
	{
		this.criticalLevelOfHealth = criticalLevelOfHealth;
	}

	@Override
	public String toString() { return super.toString() + ", criticalLevelOfHealth = " + criticalLevelOfHealth; }
}
