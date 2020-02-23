package ua.external.base.oop.droid.droids.behavior;

import java.io.Serializable;

public class NoEnergy implements EnergyBehavior, Serializable {
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
