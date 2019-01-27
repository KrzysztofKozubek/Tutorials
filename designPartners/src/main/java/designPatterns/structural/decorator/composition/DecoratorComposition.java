package designPatterns.structural.decorator.composition;

import designPatterns.structural.decorator.Widget;

public class DecoratorComposition implements Widget {

    private Widget widget;

    public DecoratorComposition(Widget widget) {
        this.widget = widget;
    }

    @Override
    public void draw() {
        System.out.println("### Decorate Composition ###");
        widget.draw();
        System.out.println("### Decorate Composition ###");
    }
}
