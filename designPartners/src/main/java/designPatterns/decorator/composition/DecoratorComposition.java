package designPatterns.decorator.composition;

import designPatterns.decorator.Widget;

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
