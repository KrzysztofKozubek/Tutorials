package designPatterns.factory;

import designPatterns.factory.impl.Circle;
import designPatterns.factory.impl.Rectangle;
import designPatterns.factory.interfaces.Shape;

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
