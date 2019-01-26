package designPatterns.singleton;

public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }

    public void showMessage() {
        System.out.println("Hello! I'm " + this);
    }
}
