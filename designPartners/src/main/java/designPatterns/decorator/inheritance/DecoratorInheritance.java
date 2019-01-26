package designPatterns.decorator.inheritance;

import designPatterns.decorator.TextField;
import designPatterns.decorator.Widget;

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
