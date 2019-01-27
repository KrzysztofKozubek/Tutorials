package designPatterns.creational.prototype;

import designPatterns.creational.prototype.interfaces.Shape;
import designPatterns.creational.prototype.impl.Circle;
import designPatterns.creational.prototype.impl.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {

    private Map<String, Shape> objects = new HashMap<>();

    public ShapeCache() {
        loadCache();
    }

    private void loadCache() {
        objects.put(Circle.class.getSimpleName(), new Circle());
        objects.put(Rectangle.class.getSimpleName(), new Rectangle());
    }

    public Shape getShape(String shape) {
        return (Shape) objects.get(shape).clone();
    }
}
