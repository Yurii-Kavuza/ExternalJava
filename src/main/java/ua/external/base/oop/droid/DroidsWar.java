package ua.external.base.oop.droid;

import ua.external.base.oop.droid.droids.droidfactory.DroidFactory;
import ua.external.base.oop.droid.views.DroidView;
import ua.external.base.oop.droid.controllers.DroidController;
import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.droidfactory.DroidMaker;
import ua.external.base.oop.droid.serialization.DroidsDeserialization;
import ua.external.base.oop.droid.serialization.DroidsSerialization;



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


        warriors.add(first);
        warriors.add(second);
        warriors.add(third);
        warriors.add(fourth);
        warriors.add(fifth);
        warriors.add(sixth);
        warriors.add(sixth);
        warriors.add(seventh);

        /*DroidsSerialization.writeDroidsToBinaryFile(warriors);
        DroidsSerialization.writeDroidsToTextFile(warriors);
        System.out.println("\n\n");
        DroidsDeserialization.readDroidsFromBinaryFile();
        System.out.println("\n\n");
        DroidsDeserialization.readDroidsFromTextFile();
        System.out.println("\n\n");*/

        DroidController controller = new DroidController(warriors,view);

        controller.startTournament();
    }
}
