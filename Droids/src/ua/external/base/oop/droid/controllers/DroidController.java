package ua.external.base.oop.droid.controllers;

import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.views.DroidView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DroidController {
    private ArrayList<Droid> droids;
    private Droid droid1;
    private Droid droid2;
    private DroidView view;

    public DroidController(ArrayList<Droid> droids, DroidView view) {
        this.droids = droids;
        this.view = view;
    }

    public void chooseLanguage() {
        Scanner scanner = new Scanner(System.in);

        view.printMessage(DroidView.CHOOSE_LANG);
        int numOfLang;

        if (scanner.hasNextInt())
            numOfLang = scanner.nextInt();
        else numOfLang = 2;

        Locale locale = numOfLang == 1 ?
                new Locale("ua", "UA") :
                new Locale("en", "EN");

        view.setLocale(locale);
    }

    public void startTournament() {
        //view.printMessage(DroidView.GREETING);
        view.printGreeting();
        //view.printMessage(DroidView.QUANTITY_OF_COMPETITORS + droids.size());
        view.printQuantityOfCompetitors(droids.size());

        while (droids.size() > 1) {
            int firstCompetitor = (int) (Math.random() * droids.size());
            droid1 = droids.get(firstCompetitor);
            droids.remove(firstCompetitor);

            int secondCompetitor = (int) (Math.random() * droids.size());
            droid2 = droids.get(secondCompetitor);
            droids.remove(secondCompetitor);

            //view.printMessage(DroidView.COMPETITORS + droid1 + " and " + droid2);
            view.printCompetitors(droid1, droid2);

            droid1.fight(droid2);

            if (droid1.getAlive() && !droid2.getAlive()) {
                //view.printMessage(DroidView.WINNER_OF_FIGHT + droid1.getResultAfterFight());
                view.printWinnerOfFight(droid1.getResultAfterFight());
                droids.add(droid1);
            } else if (!droid1.getAlive() && droid2.getAlive()) {
                //view.printMessage(DroidView.WINNER_OF_FIGHT + droid2.getResultAfterFight());
                view.printWinnerOfFight(droid2.getResultAfterFight());
                droids.add(droid2);
            } else if (droid1.getAlive() && droid2.getAlive()) {
                //view.printMessage(droid1.getResultAfterFight() + DroidView.NO_WINNER);
                view.printNoWinner(droid1.getResultAfterFight());
                droids.add(droid1);
                droids.add(droid2);
            }

            if (droids.size() > 1) {
                //view.printMessage(DroidView.QUANTITY_OF_COMPETITORS + droids.size());
                view.printQuantityOfCompetitors(droids.size());
            }
        }

        //view.printMessage(DroidView.WINNER_OF_TOURNAMENT + droids.get(0));
        view.printWinnerOfTournament(droids.get(0));
        //view.printMessage(DroidView.BEFORE_WE_PART);
        view.printBeforeWePart();
    }
}
