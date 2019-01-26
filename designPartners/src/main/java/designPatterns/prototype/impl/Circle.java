package designPatterns.prototype.impl;

import designPatterns.prototype.interfaces.Shape;

public class Circle extends Shape {

    public Circle() {
        this.type = this.getClass().getSimpleName();
    }

    @Override
    public void draw() {
        System.out.println("Circle::draw");
    }
}
