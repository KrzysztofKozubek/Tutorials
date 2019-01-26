package designPatterns.decorator;

import designPatterns.decorator.composition.DecoratorComposition;
import designPatterns.decorator.inheritance.DecoratorInheritance;

public class App {

    public static void main(String[] args) {
        Widget widget1 = new DecoratorComposition(new TextField(100, 100));
        Widget widget2 = new DecoratorInheritance(100, 100);

        widget1.draw();
        widget2.draw();
    }
}
