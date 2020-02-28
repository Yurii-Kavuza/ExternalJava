package ua.external.base.oop.droid.droids.behavior;

public interface Flyable {
    default void startFly(){
        System.out.println("I am flying.");
    }
    default void stopFly(){
        System.out.println("I am not flying");
    }
}
