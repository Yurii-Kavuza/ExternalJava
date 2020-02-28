package ua.external.base.oop.junittests.droidstests;

import org.junit.Assert;
import org.junit.Test;
import ua.external.base.oop.droid.droids.HouseworkerDroid;

public class HouseworkerDroidTest
{
    @Test
    public void HouseworkerDroidConstructorWithResponsibilityTest()
    {
        HouseworkerDroid houseworkerDroid =
                new HouseworkerDroid(30, 35, 35, "Mat", "Wash the dishes");
        int expectedHealth = 30;
        int actualHealth = houseworkerDroid.getHealth();
        int expectedEnergy = 0;
        int actualEnergy = houseworkerDroid.performEnergy();
        int expectedDamage = 0;
        int actualDamage = houseworkerDroid.performDamage();
        String expectedName = "Mat";
        String actualName = "Mat";
        String expectedResponsibility = "Wash the dishes";
        String actualResponsibility = houseworkerDroid.getResponsibility();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedResponsibility, actualResponsibility);
    }

    @Test
    public void HouseworkerDroidEssentialConstructorTest()
    {
        HouseworkerDroid houseworkerDroid =
                new HouseworkerDroid(30, 35, 35, "Mat");
        int expectedHealth = 30;
        int actualHealth = houseworkerDroid.getHealth();
        int expectedEnergy = 0;
        int actualEnergy = houseworkerDroid.performEnergy();
        int expectedDamage = 0;
        int actualDamage = houseworkerDroid.performDamage();
        String expectedName = "Mat";
        String actualName = houseworkerDroid.getName();
        String expectedResponsibility = "undefined";
        String actualResponsibility = houseworkerDroid.getResponsibility();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedResponsibility, actualResponsibility);
        Assert.assertEquals(expectedName, actualName);
    }
}
