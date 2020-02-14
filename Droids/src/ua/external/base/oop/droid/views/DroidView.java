package ua.external.base.oop.droid.views;

import ua.external.base.oop.droid.droids.Droid;

import java.util.Locale;
import java.util.ResourceBundle;

public class DroidView {
    static String MESSAGES_BUNDLE_NAME = "property.messages";
    private ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("en", "EN"));

    public void setLocale(Locale locale) {
        bundle =
                ResourceBundle.getBundle(
                        MESSAGES_BUNDLE_NAME, locale);
    }

    public static final String CHOOSE_LANG = "Hi! Dear user, please, choose the language:\n1 - ua;\n2-us (default);";


    /*public static final String GREETING = "Welcome aboard, ladies and gentlemen. Today we see amazing tournament between droids.";
    public static final String QUANTITY_OF_COMPETITORS = "The quantity of competitors is ";
    public static final String COMPETITORS = "The fight is between ";
    public static final String WINNER_OF_FIGHT = "The winner of fight is ";
    public static final String NO_WINNER = " Let's start the next fight.";
    public static final String WINNER_OF_TOURNAMENT = "The winner of tournament is ";
    public static final String BEFORE_WE_PART = "It was fantastic competition. See you next time here.";*/

    public static final String SPACE = " ";

    public static final String GREETING_KEY = "input.greeting";
    public static final String QUANTITY_OF_COMPETITORS_KEY = "input.quantity.of.competitors";
    public static final String COMPETITORS_KEY = "input.competitors";
    public static final String WINNER_OF_FIGHT_KEY = "input.winner";
    public static final String NO_WINNER_KEY = "input.no.winner";
    public static final String WINNER_OF_TOURNAMENT_KEY = "input.winner.tournament";
    public static final String BEFORE_WE_PART_KEY = "input.before.we.part";

    public static final String AND_KEY = "input.and";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGreeting() {
        printMessage(bundle.getString(GREETING_KEY));
    }

    public void printQuantityOfCompetitors(int quantity) {
        printMessage(bundle.getString(QUANTITY_OF_COMPETITORS_KEY) + SPACE + quantity);
    }

    public void printCompetitors(Droid droidFirst, Droid droidSecond) {
        printMessage(bundle.getString(COMPETITORS_KEY) + SPACE + droidFirst +
                SPACE + bundle.getString(AND_KEY) + SPACE + droidSecond);
    }

    public void printWinnerOfFight(String resultAfterFight) {
        printMessage(bundle.getString(WINNER_OF_FIGHT_KEY) + SPACE + resultAfterFight);
    }

    public void printNoWinner(String resultAfterFight) {
        printMessage(resultAfterFight + bundle.getString(NO_WINNER_KEY));
    }

    public void printWinnerOfTournament(Droid droid) {
        printMessage(bundle.getString(WINNER_OF_TOURNAMENT_KEY) + SPACE + droid);
    }

    public void printBeforeWePart() {
        printMessage(bundle.getString(BEFORE_WE_PART_KEY));
    }
}
