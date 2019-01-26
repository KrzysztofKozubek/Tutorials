package designPatterns.factory.interfaces;

public interface Shape {
    default void draw() {
        System.out.println("Drawing " + this.getClass().getSimpleName());
    }
}
