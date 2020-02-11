package ua.external.base.oop.droid.droids;

public class SelfHealingDroid extends Droid {
    private double recoveryRatio;

    public SelfHealingDroid(int health, int energy, int damage, String name, double recoveryRatio) {
        super((int) (health * recoveryRatio),energy, damage,name);
        this.recoveryRatio = recoveryRatio;
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
