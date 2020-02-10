package ua.external.base.oop.droid.droids;

import java.util.ArrayList;

public class HouseworkerDroid extends Droid {
    private String responsibility;

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public HouseworkerDroid(int health, int energy, int damage, String name, String responsibility) {
        super(health, energy, damage, name);
        this.responsibility = responsibility;
    }

    public HouseworkerDroid(int health, int energy, int damage, String name) {
        super(health, energy, damage, name);
    }

    @Override
    public String toString() {
        return super.toString() + ", responsibility is" + responsibility;
    }
}
