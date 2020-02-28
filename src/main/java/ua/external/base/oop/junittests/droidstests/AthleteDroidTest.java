package ua.external.base.oop.junittests.droidstests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.external.base.oop.droid.droids.AthleteDroid;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AthleteDroidTest
{
    private double input;
    private int expectedOutput;

    public  AthleteDroidTest(double inputMultiPower, int expectedDamage)
    {
        this.input = inputMultiPower;
        this.expectedOutput = expectedDamage;
    }

    @Parameterized.Parameters
    public static Collection Data()
    {
        Object expectedOutputs[][] = {{1.0, 30}, {1.2, 36}, {-3, 30}};
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void AthleteDroidConstructorWithMultiPowerTest()
    {
        AthleteDroid athleteDroid = new AthleteDroid(30, 40, 30, "Ben", input);
        Assert.assertEquals(expectedOutput, athleteDroid.performDamage());
    }

    @Test
    public void AthleteDroidConstructorTest()
    {
        AthleteDroid athleteDroid = new AthleteDroid(30, 40, 30, "Tom");
        double actualMultiPower = athleteDroid.getMultiplyPower();
        double expectedMultiPower = 1.0;
        Assert.assertEquals(expectedMultiPower, actualMultiPower, 0.01);
    }
}
