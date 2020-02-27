package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.Repairable;

public class DoctorDroid extends Droid implements Repairable {

	private int criticalLevelOfHealth = 10;

	protected DoctorDroid(Builder builder) {
		super(builder);
	}

	public static class Builder extends Droid.Builder<Builder>{
		private int criticalLevelOfHealth = 10;

		public Builder(int health, int energy, int damage, String name) {
			super(health, energy, damage, name);
		}

		public Builder criticalLevelOfHealth (int value){
			this.criticalLevelOfHealth= value;
			return this;
		}

		@Override
		public DoctorDroid build() {
			return new DoctorDroid(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
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

	@Override
	public String toString() { return super.toString() + ", criticalLevelOfHealth = " + criticalLevelOfHealth; }
}
