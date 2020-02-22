package ua.external.base.oop.droid.droids;


import ua.external.base.oop.droid.droids.behavior.NoDamage;
import ua.external.base.oop.droid.droids.behavior.NoEnergy;


public class HouseworkerDroid extends Droid {
    private String responsibility;

    public HouseworkerDroid(int health, int energy, int damage, String name, String responsibility) {
        damageBehavior = new NoDamage();
        energyBehavior = new NoEnergy();
        setEssentialParameters(health,energy,damage,name);
        this.responsibility = responsibility;
    } 
    public HouseworkerDroid(int health, int energy, int damage, String name) {
        this(health, energy, damage, name, "undefined");
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @Override
    public String toString() {
        return super.toString() + ", responsibility is " + responsibility;
    }
}
