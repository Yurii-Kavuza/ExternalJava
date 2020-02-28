package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageWithoutWeapon;
import ua.external.base.oop.droid.droids.behavior.Diveable;
import ua.external.base.oop.droid.droids.behavior.EnergyUsual;


public class AthleteDroid extends Droid implements Diveable {
    private double multiplyPower;

    public AthleteDroid(int health, int energy, int damage, String name, double multiplyPower) {
        damageBehavior = new DamageWithoutWeapon(damage);
        energyBehavior = new EnergyUsual(energy);
        setEssentialParameters(health,energy,damage,name);
        this.multiplyPower=multiplyPower;
        if(multiplyPower>1){
            this.damageBehavior.setDamage((int)(this.damageBehavior.getDamage()*multiplyPower));
        }else {
            this.damageBehavior.setDamage((int)(this.damageBehavior.getDamage()*1));
        }
    }

    public AthleteDroid(int health, int energy, int damage, String name) {
        this(health, energy, damage, name, 1.0);
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

    @Override
    public void startDive() {
        System.out.println("I am diving. I can deep dive");
    }

    @Override
    public void stopDive() {
        System.out.println("I am not diving");
    }
}
