package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageBehavior;
import ua.external.base.oop.droid.droids.behavior.EnergyBehavior;
import ua.external.base.oop.droid.droids.behavior.NoDamage;
import ua.external.base.oop.droid.droids.behavior.NoEnergy;

public class HouseworkerDroid extends Droid  {
    private String responsibility;
    DamageBehavior damageBehavior = new NoDamage();
    EnergyBehavior energyBehavior = new NoEnergy();

    protected HouseworkerDroid(Builder builder) {
        super(builder);
        responsibility = builder.responsibility;

    }

    public static class Builder extends Droid.Builder<Builder>{
        private String responsibility;
        EnergyBehavior energyBehavior = new NoEnergy();
        DamageBehavior damageBehavior = new NoDamage();

        public Builder(int health, int energy, int damage, String name) {
            super(health, energy, damage, name);

        }

        public Builder  responsibility (String value){
            responsibility= value;
            return this;
        }

        @Override
        public HouseworkerDroid build() {
            return new HouseworkerDroid(this);
        }

        @Override
        protected Builder self(){
            return this;
        }
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @Override
    public String toString() {
        return super.toString() + ", responsibility is " + responsibility;
    }
}
