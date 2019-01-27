package designPatterns.creational.prototype.impl;

import designPatterns.creational.prototype.interfaces.Shape;

public class Rectangle extends Shape {

    public Rectangle() {
        this.type = this.getClass().getSimpleName();
    }

    @Override
    public void draw() {
        System.out.println("Rectangle::draw");
    }
}
