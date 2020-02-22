package ua.external.base.oop.droid.droids.behavior;

import java.io.Serializable;

public class EnergyUsual implements EnergyBehavior, Serializable {
    int energy=30;

    public EnergyUsual() {
    }

    public EnergyUsual(int energy) {
        this.energy = energy;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy() {
        this.energy=30;
    }

    @Override
    public void setEnergy(int value) {
        this.energy=value;
    }
}
