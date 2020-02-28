package ua.external.base.oop.junittests.droidstests;

import org.junit.Assert;
import org.junit.Test;
import ua.external.base.oop.droid.droids.FlightDroid;

public class FlightDroidTest
{
    @Test
    public void FlightDroidConstructorTest()
    {
        FlightDroid flightDroid = new FlightDroid(35, 35, 30, "Peter");
        int expectedHealth = 35;
        int actualHealth = flightDroid.getHealth();
        int expectedEnergy = 35;
        int actualEnergy = flightDroid.performEnergy();
        int expectedDamage = 30;
        int actualDamage = flightDroid.performDamage();
        String expectedName = "Peter";
        String actualName = "Peter";

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
    }
}
