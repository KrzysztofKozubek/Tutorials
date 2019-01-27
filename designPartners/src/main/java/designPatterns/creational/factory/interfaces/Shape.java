package designPatterns.creational.factory.interfaces;

public interface Shape {
    default void draw() {
        System.out.println("Drawing " + this.getClass().getSimpleName());
    }
}
