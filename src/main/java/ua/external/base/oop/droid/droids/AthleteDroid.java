package ua.external.base.oop.droid.droids;



public class AthleteDroid extends Droid {
    private double multiplyPower;

    protected AthleteDroid(Builder builder) {
        super(builder);
        multiplyPower=builder.multiplyPower;
    }

    public static class Builder extends Droid.Builder<Builder>{
        private double multiplyPower;

        public Builder(int health, int energy, int damage, String name) {
            super(health, energy, damage, name);
        }

        public Builder multiplyPower (double value){
            multiplyPower= value;
            return this;
        }

        @Override
        public AthleteDroid build() {
            return new AthleteDroid(this);
        }

        @Override
        protected Builder self(){
            return this;
        }
    }

    public double getMultiplyPower() {
        return multiplyPower;
    }

    public void setMultiplyPower(double multiplyPower) {
        this.multiplyPower = multiplyPower;
    }

    @Override
    public String toString() {
        return super.toString() + ", multiplyPower = " + multiplyPower;
    }
}
