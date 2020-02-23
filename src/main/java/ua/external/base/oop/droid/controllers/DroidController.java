package ua.external.base.oop.droid.controllers;


import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.resource.Keys;
import ua.external.base.oop.droid.resource.ResourceManager;
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

        view.printMessage(Keys.CHOOSE_LANG);
        int numOfLang;

        if (scanner.hasNextInt())
            numOfLang = scanner.nextInt();
        else numOfLang = 2;

        Locale locale = numOfLang == 1 ?
                new Locale("ua", "UA") :
                new Locale("en", "EN");

        ResourceManager resourceManager = ResourceManager.INSTANCE;
        resourceManager.changeResource(locale);
    }

    public void startTournament() {
        chooseLanguage();
        view.printGreeting();
        view.printQuantityOfCompetitors(droids.size());

        while (droids.size() > 1) {
            int firstCompetitor = (int) (Math.random() * droids.size());
            droid1 = droids.get(firstCompetitor);
            droids.remove(firstCompetitor);

            int secondCompetitor = (int) (Math.random() * droids.size());
            droid2 = droids.get(secondCompetitor);
            droids.remove(secondCompetitor);

            view.printCompetitors(droid1, droid2);

            droid1.fight(droid2);

            if (droid1.getAlive() && !droid2.getAlive()) {
                view.printWinnerOfFight(droid1.getResultAfterFight());
                droids.add(droid1);
            } else if (!droid1.getAlive() && droid2.getAlive()) {
                view.printWinnerOfFight(droid2.getResultAfterFight());
                droids.add(droid2);
            } else if (droid1.getAlive() && droid2.getAlive()) {
                view.printNoWinner(droid1.getResultAfterFight());
                droids.add(droid1);
                droids.add(droid2);
            }

            if (droids.size() > 1) {
                view.printQuantityOfCompetitors(droids.size());
            }
        }

        view.printWinnerOfTournament(droids.get(0));
        view.printBeforeWePart();
    }
}
