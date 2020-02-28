package ua.external.base.oop.junittests.droidstests;

import org.junit.Assert;
import org.junit.Test;
import ua.external.base.oop.droid.droids.DoublePowerDroid;

public class DoublePowerDroidTest
{
    @Test
   public void DoublePowerDroidConstructorTest()
   {
       DoublePowerDroid doublePowerDroid = new DoublePowerDroid(30, 40, 30, "Sam");
       int expectedHealth = 30;
       int actualHealth = doublePowerDroid.getHealth();
       int expectedEnergy = 40;
       int actualEnergy = doublePowerDroid.performEnergy();
       int expectedDamage = 30 * 2;
       int actualDamage = doublePowerDroid.performDamage();
       String expectedName = "Sam";
       String actualName = "Sam";

       Assert.assertEquals(expectedHealth, actualHealth);
       Assert.assertEquals(expectedEnergy, actualEnergy);
       Assert.assertEquals(expectedDamage, actualDamage);
       Assert.assertEquals(expectedName, actualName);
   }
}
