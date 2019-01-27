package designPatterns.creational.singleton;

public class App {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton1.showMessage();
        singleton2.showMessage();

        System.out.println(singleton1 == singleton2);
    }
}
