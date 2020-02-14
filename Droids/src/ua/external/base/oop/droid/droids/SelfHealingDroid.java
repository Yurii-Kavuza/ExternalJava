package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.Repairable;

public class SelfHealingDroid extends Droid implements Repairable {
    private double recoveryRatio;

    public SelfHealingDroid(int health, int energy, int damage, String name, double recoveryRatio) {
        super((int) (health * recoveryRatio),energy, damage,name);
        this.recoveryRatio = recoveryRatio;
    }

    public SelfHealingDroid(int health, int energy, int damage, String name)
    {
        super(health, energy, damage, name);
        this.recoveryRatio = 1;
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
