package designPatterns.creational.factory;

import designPatterns.creational.factory.interfaces.Shape;

/*
* Factory is used when
* is needed create many objects but all the time in the same way
* */
public class App {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape(ShapesEnum.CIRCLE);
        Shape shape2 = shapeFactory.getShape(ShapesEnum.RECTANGLE);

        shape1.draw();
        shape2.draw();
    }
}
