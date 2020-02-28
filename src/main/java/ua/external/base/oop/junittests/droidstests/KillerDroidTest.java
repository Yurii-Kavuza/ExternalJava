package ua.external.base.oop.junittests.droidstests;

import org.junit.Assert;
import org.junit.Test;
import ua.external.base.oop.droid.droids.DoublePowerDroid;
import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.KillerDroid;

public class KillerDroidTest
{
    @Test
    public void KillerDroidConstructorTest()
    {
        KillerDroid killerDroid = new KillerDroid(35, 35, 30, "Bob");

        int expectedHealth = 35;
        int actualHealth = killerDroid.getHealth();
        int expectedEnergy = 35;
        int actualEnergy = killerDroid.performEnergy();
        int expectedDamage = 30;
        int actualDamage = killerDroid.performDamage();
        String expectedName = "Bob";
        String actualName = "Bob";

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public  void killEnemyTest()
    {
        Droid enemy = new DoublePowerDroid(30, 40, 30, "Bob");
        KillerDroid killerDroid = new KillerDroid(30, 30, 40, "Robert");
        killerDroid.killEnemy(enemy);
        int actualEnemyHealth = enemy.getHealth();
        int actualKillerDamage = killerDroid.performDamage();
        int expectedEnemyHealth = 0;
        int expectedKillerDamage = 40;

        Assert.assertEquals(expectedEnemyHealth, actualEnemyHealth);
        Assert.assertEquals(expectedKillerDamage, actualKillerDamage);
    }
}
