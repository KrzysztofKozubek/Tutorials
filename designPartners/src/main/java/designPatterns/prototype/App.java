package designPatterns.prototype;

import designPatterns.prototype.impl.Circle;
import designPatterns.prototype.impl.Rectangle;

public class App {
    public static void main(String[] args) {
        ShapeCache shapeCache = new ShapeCache();

        System.out.println(shapeCache.getShape(Circle.class.getSimpleName()).getType());
        System.out.println(shapeCache.getShape(Rectangle.class.getSimpleName()).getType());
    }
}
