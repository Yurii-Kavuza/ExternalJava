package ua.external.base.oop.droid.droids;

public class AthleteDroid extends Droid {
    private double multiplyPower;
    public AthleteDroid(int health, int energy, int damage, String name, double multiplyPower) {
        super(health, energy, damage, name);
        if(multiplyPower>1){
            this.setDamage((int)(this.getDamage()*multiplyPower));
        }else{
            this.setDamage((int)(this.getDamage()*1));
        }
    }

    public AthleteDroid(int health, int energy, int damage, String name) {
        super(health, energy, damage, name);
    }

    @Override
    public String toString() {
        return super.toString() + ", multiplyPower =" + multiplyPower;
    }
}
