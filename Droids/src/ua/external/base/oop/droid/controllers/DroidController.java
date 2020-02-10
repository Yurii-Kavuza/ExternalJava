package ua.external.base.oop.droid.controllers;

import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.views.DroidView;

import java.util.ArrayList;

public class DroidController {
    private ArrayList<Droid> droids;
    private Droid droid1;
    private Droid droid2;
    private DroidView view;

    public DroidController(ArrayList<Droid> droids, DroidView view) {
        this.droids = droids;
        this.view = view;
    }

    public void startTournament() {
        view.printMessage(DroidView.GREETING);
        view.printMessage(DroidView.QUANTITY_OF_COMPETITORS + droids.size());
        view.printMessage(DroidView.QUANTITY_OF_COMPETITORS + droids.size());
        while(droids.size()>1){
            int firstCompetitor=(int)(Math.random()*droids.size());
            droid1=droids.get(firstCompetitor);
            droids.remove(firstCompetitor);
            int secondCompetitor=(int)(Math.random()*droids.size());
            droid2=droids.get(secondCompetitor);
            droids.remove(secondCompetitor);
            view.printMessage(DroidView.COMPETITORS + droid1 + " and " + droid2);
            droid1.fight(droid2);
            if(droid1.getAlive()&&!droid2.getAlive()){
                view.printMessage(DroidView.WINNER_OF_FIGHT + droid1.getResultAfterFight());
                droids.add(droid1);
            }else if(!droid1.getAlive()&&droid2.getAlive()){
                view.printMessage(DroidView.WINNER_OF_FIGHT + droid2.getResultAfterFight());
                droids.add(droid2);
            }else if(droid1.getAlive()&&droid2.getAlive()) {
                view.printMessage(droid1.getResultAfterFight() + DroidView.NO_WINNER);
                droids.add(droid1);
                droids.add(droid2);
            }
        }
        view.printMessage(DroidView.WINNER_OF_TOURNAMENT + droids.get(0));
        view.printMessage(DroidView.BEFORE_WE_PART);
    }
}
