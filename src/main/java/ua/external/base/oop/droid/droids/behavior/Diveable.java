package ua.external.base.oop.droid.droids.behavior;

public interface Diveable {
    default void startDive(){
        System.out.println("I am diving");
    }
    default void stopDive(){
        System.out.println("I am not diving");
    }
}
