package ua.external.base.oop.droid.droids;

import org.jetbrains.annotations.NotNull;

public abstract class Droid {
    private int MAX_VALUE=100;
    private String name;
    private int health;
    private int energy;
    private int damage;
    private int attemptOfPower;
    private boolean alive = true;
    private String resultAfterFight;

    public Droid(int health, int energy, int damage, String name) {
        if((health + energy + damage)>MAX_VALUE || ((health + energy + damage)<1 && health<1)) {
            this.setHealth(0);
            this.setEnergy(0);
            this.setDamage(0);
            this.alive =false;
            this.name="Broken droid";
            System.out.println("Pay attention! Sum of health's, energy's and damage's points must be " + MAX_VALUE +
                    ". You have created broken droid and it can not fight because it is not alive.");
        }else if(energy<1 && damage<1){
            this.health = health;
            this.energy = energy;
            this.damage = damage;
            this.name=name;
            System.out.println("Pay attention! You have created droid that can not fight and protect itself.");
        }else if(energy<1){
            this.health = health;
            this.energy = energy;
            this.damage = damage;
            this.name=name;
            System.out.println("Pay attention! You have created droid that can not protect itself.");
        }else if(damage<1){
            this.health = health;
            this.energy = energy;
            this.damage = damage;
            this.name=name;
            System.out.println("Pay attention! You have created droid that can not fight.");
        }else{
            this.health = health;
            this.energy = energy;
            this.damage = damage;
            this.name=name;
        }
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public int attempts (@NotNull Droid droid){
        int attempt=0;
        int delta;
        boolean haveHealth=true;

        if (this.getDamage()>=droid.getEnergy()){
            delta=(this.getDamage()-droid.getEnergy())*2;
        }else {
            delta=(droid.getEnergy()-this.getDamage())/2;
        }
        while(haveHealth){
            droid.setHealth(droid.getHealth()-delta);
            if (droid.getHealth()<=0){
                attempt++;
                haveHealth=false;
            }else {
                attempt++;
            }
        }
        return attempt;
    }

    public void fight(@NotNull Droid droid){
        int healthDroidFirstBefore=this.getHealth();
        int healthDroidSecondBefore=droid.getHealth();

        if (this.attempts(droid)>droid.attempts(this)){
            this.setHealth(healthDroidFirstBefore);
            droid.setAlive(false);
            this.setResultAfterFight("" + this.getName() + " " + this.getClass().getSimpleName() + " has won " +
                    "fight against " + droid.getName() + " " + droid.getClass().getSimpleName() + " making " +
                    this.attempts(droid) + " attempts.");
        }else if(this.attempts(droid)<droid.attempts(this)){
            droid.setHealth(healthDroidFirstBefore);
            this.setAlive(false);
            droid.setResultAfterFight("" + droid.getName() + " " + droid.getClass().getSimpleName() + " has won " +
                    "fight against " + this.getName() + " " + this.getClass().getSimpleName() + " making " +
                    droid.attempts(this) + " attempts.");
        }else {
            this.setHealth(healthDroidFirstBefore);
            droid.setHealth(healthDroidFirstBefore);
            this.setResultAfterFight("Nobody has won in fight between " + this.getName() + " "
                    + this.getClass().getSimpleName() + " and " + droid.getName() + " " +
                    droid.getClass().getSimpleName());
            droid.setResultAfterFight("Nobody has won in fight between " + droid.getName() + " "
                    + droid.getClass().getSimpleName() + " and " + this.getName() + " " +
                    this.getClass().getSimpleName());
        }
    }

    @Override
    public String toString() {
        return "" + this.getClass().getSimpleName() +
                " name is " + name +
                ", health=" + health +
                ", energy=" + energy +
                ", damage=" + damage;
    }
}
