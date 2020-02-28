package ua.external.base.oop.junittests.droidstests;

import org.junit.Assert;
import org.junit.Test;
import ua.external.base.oop.droid.droids.SelfHealingDroid;

public class SelfHealingDroidTest
{
    @Test
    public void SelfHealingDroidConstructorWithRecoveryRatio()
    {
        SelfHealingDroid selfHealingDroid = new SelfHealingDroid(30, 40, 30, "Kate", 1.3);
        int expectedHealth = (int)(30 * 1.3);
        int actualHealth = selfHealingDroid.getHealth();
        int expectedEnergy = 40;
        int actualEnergy = selfHealingDroid.performEnergy();
        int expectedDamage = 30;
        int actualDamage = selfHealingDroid.performDamage();
        String expectedName = "Kate";
        String actualName = "Kate";
        double expectedRecoveryRatio = 1.3;
        double actualRecoveryRatio = selfHealingDroid.getRecoveryRatio();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedRecoveryRatio, actualRecoveryRatio, 0.009);
    }

    @Test
    public void SelfHealingDroidEssentialConstructor()
    {
        SelfHealingDroid selfHealingDroid = new SelfHealingDroid(30, 40, 30, "Kate");
        int expectedHealth = 30;
        int actualHealth = selfHealingDroid.getHealth();
        int expectedEnergy = 40;
        int actualEnergy = selfHealingDroid.performEnergy();
        int expectedDamage = 30;
        int actualDamage = selfHealingDroid.performDamage();
        String expectedName = "Kate";
        String actualName = "Kate";
        double expectedRecoveryRatio = 1.0;
        double actualRecoveryRatio = selfHealingDroid.getRecoveryRatio();

        Assert.assertEquals(expectedHealth, actualHealth);
        Assert.assertEquals(expectedEnergy, actualEnergy);
        Assert.assertEquals(expectedDamage, actualDamage);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedRecoveryRatio, actualRecoveryRatio, 0.009);
    }
}