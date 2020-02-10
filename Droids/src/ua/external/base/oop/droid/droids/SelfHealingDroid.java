package ua.external.base.oop.droid.droids;

public class SelfHealingDroid extends Droid {
    private double recoveryRatio;

    public SelfHealingDroid(int energy, int damage, int health, double recoveryRatio) {
        super(energy, damage, (int) (health * recoveryRatio));
        this.recoveryRatio = recoveryRatio;
    }

    public double getRecoveryRatio() {
        return recoveryRatio;
    }

    public void setRecoveryRatio(double recoveryRatio) {
        this.recoveryRatio = recoveryRatio;
    }

    @Override
    public String toString() {
        return super.toString() + ", recoveryRatio=" + recoveryRatio;
    }
}
