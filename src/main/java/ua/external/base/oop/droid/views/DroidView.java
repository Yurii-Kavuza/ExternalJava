package ua.external.base.oop.droid.views;

import ua.external.base.oop.droid.droids.Droid;
import ua.external.base.oop.droid.resource.Keys;
import ua.external.base.oop.droid.resource.ResourceManager;

import java.util.ArrayList;

public class DroidView {
    private ResourceManager resourceManager = ResourceManager.INSTANCE;

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGreeting() {
        printMessage(resourceManager.getString(Keys.GREETING_KEY));
    }

    public void printStartMenu() {
        printMessage(
                resourceManager.getString(Keys.ACTION_WELCOME) +
                        resourceManager.getString(Keys.CHOOSE_ACTION) +
                        resourceManager.getString(Keys.ACTION_SIGN_UP) +
                        resourceManager.getString(Keys.ACTION_SIGN_IN) +
                        resourceManager.getString(Keys.ACTION_EXIT));
    }

    public void printUserMenu() {
        printMessage(
                resourceManager.getString(Keys.CHOOSE_ACTION) +
                        resourceManager.getString(Keys.ACTION_START_TOURNAMENT) +
                        resourceManager.getString(Keys.ACTION_DO_BET) +
                        resourceManager.getString(Keys.ACTION_LOGOUT) +
                        resourceManager.getString(Keys.ACTION_EXIT));
    }

    public void printAdminMenu() {
        printMessage(
                resourceManager.getString(Keys.CHOOSE_ACTION) +
                        resourceManager.getString(Keys.ACTION_START_TOURNAMENT) +
                        resourceManager.getString(Keys.ACTION_SEE_ALL_DROIDS) +
                        resourceManager.getString(Keys.ACTION_LOGOUT) +
                        resourceManager.getString(Keys.ACTION_ADD) +
                        resourceManager.getString(Keys.ACTION_DELETE) +
                        resourceManager.getString(Keys.ACTION_EXIT));
    }

    public void printQuantityOfCompetitors(int quantity) {
        printMessage(resourceManager.getString(Keys.QUANTITY_OF_COMPETITORS_KEY) + Keys.SPACE + quantity);
    }

    public void printCompetitors(Droid droidFirst, Droid droidSecond) {
        printMessage(resourceManager.getString(Keys.COMPETITORS_KEY) + Keys.SPACE + droidFirst +
                Keys.SPACE + resourceManager.getString(Keys.AND_KEY) + Keys.SPACE + droidSecond);
    }

    public void printWinnerOfFight(String resultAfterFight) {
        printMessage(resourceManager.getString(Keys.WINNER_OF_FIGHT_KEY) + Keys.SPACE + resultAfterFight);
    }

    public void printNoWinner(String resultAfterFight) {
        printMessage(resultAfterFight + resourceManager.getString(Keys.NO_WINNER_KEY));
    }

    public void printWinnerOfTournament(Droid droid) {
        printMessage(resourceManager.getString(Keys.WINNER_OF_TOURNAMENT_KEY) + Keys.SPACE + droid);
    }

    public void printBeforeWePart() {
        printMessage(resourceManager.getString(Keys.BEFORE_WE_PART_KEY));
    }

    public void printDroidsInfo(ArrayList<Droid> droids){
        for (int i =0;i<droids.size();i++)
            printMessage(i+" - "+ droids.get(i).toString() + '\n');
    }

    public void printMessageByKey(String key) {
        printMessage(resourceManager.getString(key));
    }
}
