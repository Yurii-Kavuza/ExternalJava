package ua.external.base.oop.droid.droids;

public class AthleteDroid extends Droid {
    private double multiplyPower;

    public AthleteDroid(int health, int energy, int damage, String name, double multiplyPower) {
        super(health, energy, damage, name);
        if(multiplyPower>1){
            this.setDamage((int)(this.getDamage()*multiplyPower));
            this.multiplyPower=multiplyPower;
        }else {
            this.setDamage((int)(this.getDamage()*1));
            this.multiplyPower=multiplyPower;
        }
    }

    public AthleteDroid(int health, int energy, int damage, String name) {
        super(health, energy, damage, name);
        this.multiplyPower=1.0;
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
