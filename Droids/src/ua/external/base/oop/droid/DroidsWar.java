package ua.external.base.oop.droid;

import ua.external.base.oop.droid.controllers.DroidController;
import ua.external.base.oop.droid.droids.AthleteDroid;
import ua.external.base.oop.droid.droids.DoctorDroid;
import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.HouseworkerDroid;
import ua.external.base.oop.droid.droids.droidfactory.*;
import ua.external.base.oop.droid.droids.droidfactory.DroidMaker;
import ua.external.base.oop.droid.views.DroidView;

import java.util.ArrayList;

public class DroidsWar {
    public static void main(String[] args) {
        DroidView view = new DroidView();
        ArrayList<Droid> warriors = new ArrayList<>();

        DroidFactory droidFactory;

        droidFactory = DroidMaker.droidMaker("HouseworkerDroid");
        Droid first = droidFactory.createDroid(40, 30, 30, "Bob");

        droidFactory = DroidMaker.droidMaker("AthleteDroid");
        Droid second = droidFactory.createDroid(35, 30, 35, "Chuck");

        droidFactory = DroidMaker.droidMaker("DoctorDroid");
        Droid third = droidFactory.createDroid(40, 35, 25, "Ben");

        droidFactory = DroidMaker.droidMaker("DoublePowerDroid");
        Droid fourth = droidFactory.createDroid(25, 45, 30, "Tobias");

        droidFactory = DroidMaker.droidMaker("FlightDroid");
        Droid fifth = droidFactory.createDroid(30, 35, 35, "John");

        droidFactory = DroidMaker.droidMaker("KillerDroid");
        Droid sixth = droidFactory.createDroid(30, 30, 40, "Peter");

        droidFactory = DroidMaker.droidMaker("SelfHealingDroid");
        Droid seventh = droidFactory.createDroid(40, 35, 25, "Mat");



       /* Droid first = new HouseworkerDroid(40,30,30, "Bob", "dishwasher");
        Droid second = new HouseworkerDroid(35,30,35, "Rob", "cleaner");
        Droid third = new AthleteDroid(35,30,35, "Chuck", 1.2);
        Droid fourth = new AthleteDroid(35,30,35, "Nick");
        Droid fifth = new AthleteDroid(45,20,35, "Ben", 0.8);
        Droid seventh = new AthleteDroid(50,20,30, "Cristian");
        Droid sixth = new AthleteDroid(45,20,35, "Tobias"); */

        warriors.add(first);
        warriors.add(second);
        warriors.add(third);
        warriors.add(fourth);
        warriors.add(fifth);
        warriors.add(sixth);
        warriors.add(sixth);
        warriors.add(seventh);

        DroidController controller = new DroidController(warriors,view);
        controller.startTournament();
    }
}
