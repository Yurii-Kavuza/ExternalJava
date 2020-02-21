package ua.external.base.oop.droid.droids;


import ua.external.base.oop.droid.droids.behavior.NoDamage;
import ua.external.base.oop.droid.droids.behavior.NoEnergy;


public class HouseworkerDroid extends Droid {
    private String responsibility;

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public HouseworkerDroid(int health, int energy, int damage, String name, String responsibility) {
        damageBehavior = new NoDamage();
        energyBehavior = new NoEnergy();
        this.setHealth(health);
        this.setName(name);
        this.damageBehavior.setDamage(damage);
        this.energyBehavior.setEnergy(energy);
        this.responsibility = responsibility;
    } 
    public HouseworkerDroid(int health, int energy, int damage, String name) {
        this(health, energy, damage, name, "undefined");
    }

    @Override
    public String toString() {
        return super.toString() + ", responsibility is " + responsibility;
    }
}
