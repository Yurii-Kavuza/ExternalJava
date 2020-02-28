package ua.external.base.oop.junittests.droidstests;

import org.junit.Assert;
import org.junit.Test;
import ua.external.base.oop.droid.droids.DoctorDroid;
import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.FlightDroid;
import ua.external.base.oop.droid.droids.SelfHealingDroid;

public class DroidTest
{
    @Test
    public void droidEssentialConstructor()
    {
        Droid droid = new DoctorDroid(30, 30, 40, "Ben");
        int expectedHealth = 30;
        int actualHealth = droid.getHealth();
        int expectedEnergy = 30;
        int actualEnergy = droid.performEnergy();
        int expectedDamage = 40;
        int actualDamage = droid.performDamage();
        String expectedName = "Ben";
        String actualName = droid.getName();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void droidEssentialConstructorParamsSumMoreThanMaxValueTest()
    {
       /* Droid droid = new DoctorDroid(70, 30, 40, "Dan");
        int expectedHealth = 0;
        int actualHealth = droid.getHealth();
        int expectedEnergy = 0;
        int actualEnergy = droid.performEnergy();
        int expectedDamage = 40;
        int actualDamage = droid.performDamage();
        String expectedName = "Broken droid";
        String actualName = droid.getName();
        boolean expectedAlive = false;
        boolean actualAlive = droid.getAlive();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAlive, actualAlive); */
    }

    @Test
    public void droidEssentialConstructorEnergyAndDamageLessThan1()
    {
        Droid droid = new SelfHealingDroid(70, -1, 0, "Dan");
        int expectedHealth = 70;
        int actualHealth = droid.getHealth();
        int expectedEnergy = -1;
        int actualEnergy = droid.performEnergy();
        int expectedDamage = 0;
        int actualDamage = droid.performDamage();
        String expectedName = "Dan";
        String actualName = droid.getName();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void droidEssentialConstructorEnergyLessThan1()
    {
        /*Droid droid = new SelfHealingDroid(30, -1, 0, "Dan");
        int expectedHealth = 30;
        int actualHealth = droid.getHealth();
        int expectedEnergy = 0;
        int actualEnergy = droid.performEnergy();
        int expectedDamage = 0;
        int actualDamage = droid.performDamage();
        String expectedName = "Dan";
        String actualName = droid.getName();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName); */
    }

    @Test
    public void droidEssentialConstructorDamageLessThan1()
    {
        Droid droid = new SelfHealingDroid(30, 40, 0, "Dan");
        int expectedHealth = 30;
        int actualHealth = droid.getHealth();
        int expectedEnergy = 40;
        int actualEnergy = droid.performEnergy();
        int expectedDamage = 0;
        int actualDamage = droid.performDamage();
        String expectedName = "Dan";
        String actualName = droid.getName();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void droidConstructorCreatingDroidBasedOnAnotherDroid()
    {
        Droid droid = new FlightDroid(25, 35, 40, "Ben");
        Droid anotherDroid = new FlightDroid(droid);
    }

    @Test
    public void setEssentialParametersTest()
    {

    }

    @Test
    public void attemptsTest()
    {

    }

    @Test
    public void fightWhenDroidAttemptsMoreThanOpponentAttemptsTest()
    {

    }

    @Test
    public void fightWhenOpponentAttemptsMoreThanDroidAttemptsTest()
    {

    }

    @Test
    public void fightWhenDroidAndOpponentAttemptsAreEqualTest()
    {

    }
}
