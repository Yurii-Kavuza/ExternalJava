package ua.external.base.oop.droid.views;

public class DroidView {
    public static final String GREETING = "Welcome aboard, ladies and gentlemen. Today we see amazing tournament between droids.";
    public static final String QUANTITY_OF_COMPETITORS = "The quantity of competitors is ";
    public static final String COMPETITORS = "The fight is between ";
    public static final String WINNER_OF_FIGHT = "The winner of fight is ";
    public static final String NO_WINNER = " Let's start the next fight.";
    public static final String WINNER_OF_TOURNAMENT = "The winner of tournament is ";
    public static final String BEFORE_WE_PART = "It was fantastic competition. See you next time here.";

    public void printMessage(String message){
        System.out.println(message);
    }
}
