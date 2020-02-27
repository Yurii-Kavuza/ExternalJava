package ua.external.base.oop.droid.droids;

import ua.external.base.oop.droid.droids.behavior.DamageBehavior;
import ua.external.base.oop.droid.droids.behavior.EnergyBehavior;
import ua.external.base.oop.droid.droids.engine.EngineType;
import ua.external.base.oop.droid.resource.Keys;
import ua.external.base.oop.droid.resource.ResourceManager;

import java.io.Serializable;

public abstract class Droid implements Serializable {
    private int MAX_VALUE = 100;
    private String name;
    private int health;
    DamageBehavior damageBehavior;
    EnergyBehavior energyBehavior;

    private boolean alive = true;
    private String resultAfterFight;

    ResourceManager resourceManager = ResourceManager.INSTANCE;

    public Droid() {
    }

    public Droid(Droid droid) {
        this.name = droid.getName();
        this.health = droid.getHealth();
        this.energyBehavior = droid.energyBehavior;
        this.damageBehavior = droid.damageBehavior;
        this.alive = true;
        droid = null;
    }

    public Droid(int health, int energy, int damage, String name) {
        if ((health + energy + damage) > MAX_VALUE || ((health + energy + damage) < 1 && health < 1)) {
            setEssentialParameters(0, 0, damage, "Broken droid");
            this.alive = false;
            System.out.println(resourceManager.getString(Keys.PAY_ATTENTION_KEY) + Keys.SPACE +
                    resourceManager.getString(Keys.SUM_COMPONENTS_KEY) + MAX_VALUE + Keys.POINT +
                    Keys.SPACE + resourceManager.getString(Keys.BROKEN_KEY));
        } else if (energy < 1 && damage < 1) {
            setEssentialParameters(health, energy, damage, name);
            System.out.println(resourceManager.getString(Keys.PAY_ATTENTION_KEY) + Keys.SPACE + resourceManager.getString(Keys.NO_FIGHT_PROTECT_KEY));
        } else if (energy < 1) {
            setEssentialParameters(health, energy, damage, name);
            System.out.println(resourceManager.getString(Keys.PAY_ATTENTION_KEY) + Keys.SPACE + resourceManager.getString(Keys.NO_PROTECT_KEY));
        } else if (damage < 1) {
            setEssentialParameters(health, energy, damage, name);
            System.out.println(resourceManager.getString(Keys.PAY_ATTENTION_KEY) + Keys.SPACE + resourceManager.getString(Keys.NO_FIGHT_KEY));
        } else {
            setEssentialParameters(health, energy, damage, name);
        }
    }

    protected void setEssentialParameters(int health, int energy, int damage, String name) {
        this.health = health;
        this.energyBehavior.setEnergy(energy);
        this.damageBehavior.setDamage(damage);
        this.name = name;
    }

    public void setDamageBehavior(DamageBehavior damageBehavior) {
        this.damageBehavior = damageBehavior;
    }

    public void setEnergyBehavior(EnergyBehavior energyBehavior) {
        this.energyBehavior = energyBehavior;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int performEnergy() {
        return energyBehavior.getEnergy();
    }

    public void modifyEnergy(int value) {
        energyBehavior.setEnergy(value);
    }

    public void modifyEnergy() {
        energyBehavior.setEnergy();
    }

    public int performDamage() {
        return damageBehavior.getDamage();
    }

    public void modifyDamage(int value) {
        damageBehavior.setDamage(value);
    }

    public void modifyDamage() {
        damageBehavior.setDamage();
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getResultAfterFight() {
        return resultAfterFight;
    }

    public void setResultAfterFight(String resultAfterFight) {
        this.resultAfterFight = resultAfterFight;
    }

    public int attempts(Droid droid) {
        int attempt = 0;
        int delta;
        boolean haveHealth = true;

        if (this.damageBehavior.getDamage() >= droid.energyBehavior.getEnergy()) {
            delta = (this.damageBehavior.getDamage() - droid.energyBehavior.getEnergy()) * 2 + 1;
        } else {
            delta = (droid.energyBehavior.getEnergy() - this.damageBehavior.getDamage()) / 2;
        }
        while (haveHealth) {
            droid.setHealth(droid.getHealth() - delta);
            if (droid.getHealth() <= 0) {
                attempt++;
                haveHealth = false;
            } else {
                attempt++;
            }
        }
        return attempt;
    }

    public void fight(Droid droid) {
        int healthDroidFirstBefore = this.getHealth();
        int healthDroidSecondBefore = droid.getHealth();

        if (this.attempts(droid) > droid.attempts(this)) {
            this.setHealth(healthDroidFirstBefore);
            droid.setAlive(false);
            this.setResultAfterFight("" + this.getName() + Keys.SPACE + this.getClass().getSimpleName() + Keys.SPACE
                    + resourceManager.getString(Keys.WON_KEY)
                    + Keys.SPACE +
                    resourceManager.getString(Keys.FIGHT_AGAINST_KEY)
                    + Keys.SPACE + droid.getName() + Keys.SPACE + droid.getClass().getSimpleName() + Keys.SPACE
                    + resourceManager.getString(Keys.MAKING_KEY) + Keys.SPACE + this.attempts(droid) + Keys.SPACE
                    + resourceManager.getString(Keys.ATTEMPTS_KEY));
        } else if (this.attempts(droid) < droid.attempts(this)) {
            droid.setHealth(healthDroidFirstBefore);
            this.setAlive(false);
            droid.setResultAfterFight("" + droid.getName() + Keys.SPACE + droid.getClass().getSimpleName() + Keys.SPACE
                    + resourceManager.getString(Keys.WON_KEY) + Keys.SPACE + resourceManager.getString(Keys.FIGHT_AGAINST_KEY)
                    + Keys.SPACE + this.getName() + Keys.SPACE + this.getClass().getSimpleName() + Keys.SPACE
                    + resourceManager.getString(Keys.MAKING_KEY) + Keys.SPACE + droid.attempts(this) + Keys.SPACE
                    + resourceManager.getString(Keys.ATTEMPTS_KEY));
        } else {
            this.setHealth(healthDroidFirstBefore);
            droid.setHealth(healthDroidSecondBefore);
            this.setResultAfterFight(resourceManager.getString(Keys.NOBODY_WON_KEY) + Keys.SPACE + this.getName()
                    + Keys.SPACE + this.getClass().getSimpleName() + Keys.SPACE + resourceManager.getString(Keys.AND_KEY)
                    + Keys.SPACE + droid.getName() + Keys.SPACE + droid.getClass().getSimpleName());
            droid.setResultAfterFight(resourceManager.getString(Keys.NOBODY_WON_KEY) + Keys.SPACE + droid.getName()
                    + Keys.SPACE + droid.getClass().getSimpleName() + Keys.SPACE + resourceManager.getString(Keys.AND_KEY)
                    + Keys.SPACE + this.getName() + Keys.SPACE + this.getClass().getSimpleName());
        }
    }

    class Engine{
        EngineType type;
        String vendor;
        int id;
        boolean isStarted;

        void start(){
            isStarted=true;
            System.out.println("The engine " + this.toString() + " is started");
        }

        void stop(){
            isStarted=false;
            System.out.println("The engine " + this.toString() + " is stopped");
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "type=" + type +
                    ", vendor='" + vendor + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "" + this.getClass().getSimpleName() +
                " name is " + name +
                ", health=" + health +
                ", energy=" + energyBehavior.getEnergy() +
                ", damage=" + damageBehavior.getDamage();
    }
}
