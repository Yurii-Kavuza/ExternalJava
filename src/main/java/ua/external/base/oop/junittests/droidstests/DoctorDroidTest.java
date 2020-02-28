package ua.external.base.oop.junittests.droidstests;

import org.junit.Assert;
import org.junit.Test;
import ua.external.base.oop.droid.droids.AthleteDroid;
import ua.external.base.oop.droid.droids.DoctorDroid;
import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.FlightDroid;

public class DoctorDroidTest
{
    @Test
    public void medicalExaminationUnhealthyPatientTest()
    {
        AthleteDroid unhealthyDroid = new AthleteDroid(30, 30, 40, "Shon");
        unhealthyDroid.setHealth(9);
        DoctorDroid doctorDroid = new DoctorDroid(30, 30, 40, "Ann");
        doctorDroid.medicalExamination(unhealthyDroid);

        int expectedHealthAfterTreatment = 9*2;
        int actualHealthAfterTreatment = unhealthyDroid.getHealth();
        Assert.assertEquals(expectedHealthAfterTreatment, actualHealthAfterTreatment);
    }

    @Test
    public void medicalExaminationHealthyPatientTest()
    {
        Droid healthyDroid = new FlightDroid(25, 45, 30, "Clara");
        DoctorDroid doctorDroid = new DoctorDroid(30, 30, 40, "Ann");
        doctorDroid.medicalExamination(healthyDroid);

        int expectedHealthAfterTreatment = 25;
        int actualHealthAfterTreatment = healthyDroid.getHealth();
        Assert.assertEquals(expectedHealthAfterTreatment, actualHealthAfterTreatment);
    }
}
