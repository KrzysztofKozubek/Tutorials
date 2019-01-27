package designPatterns.creational.factory;

import designPatterns.creational.factory.impl.Circle;
import designPatterns.creational.factory.impl.Rectangle;
import designPatterns.creational.factory.interfaces.Shape;

public class ShapeFactory {
    public Shape getShape(ShapesEnum shape) {
        switch (shape) {
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
        }
        return null;
    }
}
