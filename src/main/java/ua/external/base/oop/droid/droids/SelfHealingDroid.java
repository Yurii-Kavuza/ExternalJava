package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageWithoutWeapon;
import ua.external.base.oop.droid.droids.behavior.EnergyUsual;
import ua.external.base.oop.droid.droids.behavior.Repairable;

public class SelfHealingDroid extends Droid implements Repairable {
    private double recoveryRatio;

    public SelfHealingDroid(int health, int energy, int damage, String name, double recoveryRatio) {
        this.recoveryRatio = recoveryRatio;
        damageBehavior = new DamageWithoutWeapon();
        energyBehavior = new EnergyUsual();
        setEssentialParameters(health,energy,damage,name);
    }

    public SelfHealingDroid(int health, int energy, int damage, String name)
    {
        this(health, energy, damage, name,1);
    }

    public double getRecoveryRatio() {
        return recoveryRatio;
    }

    public void setRecoveryRatio(double recoveryRatio) {
        this.recoveryRatio = recoveryRatio;
    }

    public String toString() {
        return super.toString() + ", recoveryRatio=" + recoveryRatio;
    }
}
