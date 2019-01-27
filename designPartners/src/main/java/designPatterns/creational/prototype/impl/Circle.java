package designPatterns.creational.prototype.impl;

import designPatterns.creational.prototype.interfaces.Shape;

public class Circle extends Shape {

    public Circle() {
        this.type = this.getClass().getSimpleName();
    }

    @Override
    public void draw() {
        System.out.println("Circle::draw");
    }
}
