package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.Repairable;

public class SelfHealingDroid extends Droid implements Repairable {
    private double recoveryRatio;

    protected SelfHealingDroid(Builder builder) {
        super(builder);
        recoveryRatio=builder.recoveryRatio;
    }

    public static class Builder extends Droid.Builder<Builder>{
        private double recoveryRatio;

        public Builder(int health, int energy, int damage, String name) {
            super(health, energy, damage, name);
        }


        public Builder recoveryRatio (double value){
            recoveryRatio = value;
            return this;
        }

        @Override
        public SelfHealingDroid build() {
            return new SelfHealingDroid(this);
        }

        @Override
        protected Builder self(){
            return this;
        }
    }

    public double getRecoveryRatio() {
        return recoveryRatio;
    }

    public void setRecoveryRatio(double recoveryRatio) {
        this.recoveryRatio = recoveryRatio;
    }

    public String toString() {
        return super.toString() + ", recoveryRatio = " + recoveryRatio;
    }
}
