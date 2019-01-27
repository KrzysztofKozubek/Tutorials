package designPatterns.structural.decorator.inheritance;

import designPatterns.structural.decorator.TextField;
import designPatterns.structural.decorator.Widget;

public class DecoratorInheritance extends TextField implements Widget {

    public DecoratorInheritance(int width, int height) {
        super(width, height);
    }

    @Override
    public void draw() {
        System.out.println("### Decorate Inheritance ###");
        super.draw();
        System.out.println("### Decorate Inheritance ###");
    }
}
