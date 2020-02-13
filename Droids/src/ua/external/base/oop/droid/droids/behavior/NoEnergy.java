package ua.external.base.oop.droid.droids.behavior;

public class NoEnergy implements EnergyBehavior {
    int energy=0;

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy() {
        this.energy=0;
    }

    @Override
    public void setEnergy(int value) {
        setEnergy();
    }
}
