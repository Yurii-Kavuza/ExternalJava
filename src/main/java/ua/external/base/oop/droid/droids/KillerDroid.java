package ua.external.base.oop.droid.droids;

public class KillerDroid extends Droid {
	// extra damage to kill another droid
	int extraDamage;

	protected KillerDroid(Builder builder) {
		super(builder);
	}

	public static class Builder extends Droid.Builder<Builder>{
		public Builder(int health, int energy, int damage, String name) {
			super(health, energy, damage, name);
		}


		@Override
		public KillerDroid build() {
			return new KillerDroid(this);
		}

		@Override
		protected Builder self(){
			return this;
		}
	}

	public void killEnemy(Droid enemy)
	{
		extraDamage += enemy.getHealth();
		this.damageBehavior.setDamage(this.damageBehavior.getDamage() + extraDamage);

		enemy.setHealth(0);
		this.damageBehavior.setDamage(this.damageBehavior.getDamage() - enemy.getHealth());
	}

	public int getExtraDamage()
	{
		return extraDamage;
	}

	@Override
	public String toString() {return super.toString() + ", extraDamage = " + extraDamage;}
}
