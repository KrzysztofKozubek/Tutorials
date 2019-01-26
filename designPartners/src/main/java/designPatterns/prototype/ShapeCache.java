package designPatterns.prototype;

import designPatterns.prototype.impl.Circle;
import designPatterns.prototype.impl.Rectangle;
import designPatterns.prototype.interfaces.Shape;

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
