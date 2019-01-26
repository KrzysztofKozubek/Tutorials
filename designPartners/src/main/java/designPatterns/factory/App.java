package designPatterns.factory;

import designPatterns.factory.interfaces.Shape;

public class App {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape(ShapesEnum.CIRCLE);
        Shape shape2 = shapeFactory.getShape(ShapesEnum.RECTANGLE);

        shape1.draw();
        shape2.draw();
    }
}
