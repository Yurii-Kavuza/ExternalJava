package ua.external.base.oop.droid.droids;

public class FlightDroid extends Droid {

	protected FlightDroid(Builder builder) {
		super(builder);
	}

	public static class Builder extends Droid.Builder<Builder>{


		public Builder(int health, int energy, int damage, String name) {
			super(health, energy, damage, name);
		}

		@Override
		public FlightDroid build() {
			return new FlightDroid(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	public void fly()
	{
		System.out.println("I am flying!");
	}
}
