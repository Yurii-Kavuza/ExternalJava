package ua.external.base.oop.droid;

import ua.external.base.oop.droid.controllers.DroidController;
import ua.external.base.oop.droid.droids.AthleteDroid;
import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.droids.HouseworkerDroid;
import ua.external.base.oop.droid.views.DroidView;

import java.util.ArrayList;

public class DroidsWar {
    public static void main(String[] args) {
        DroidView view = new DroidView();
        ArrayList<Droid> list = new ArrayList<>();
        Droid first = new HouseworkerDroid(40,30,30, "Bob", "dishwasher");
        Droid second = new HouseworkerDroid(35,30,35, "Rob", "cleaner");
        /*Droid third = new AthleteDroid(35,30,35, "Chuck", 1.2);
        Droid fourth = new AthleteDroid(35,30,35, "Nick");
        Droid fifth = new AthleteDroid(45,20,35, "Ben", 0.8);
        Droid seventh = new AthleteDroid(50,20,30, "Cristian");
        Droid sixth = new AthleteDroid(45,20,35, "Tobias");*/

        list.add(first);
        list.add(second);
        /*list.add(third);
        list.add(fourth);
        list.add(fifth);
        list.add(sixth);
        list.add(sixth);
        list.add(seventh);*/

        DroidController controller = new DroidController(list,view);
        controller.chooseLanguage();
        controller.startTournament();
    }
}
