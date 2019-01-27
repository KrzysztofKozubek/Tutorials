package designPatterns.creational.factory.impl;

import designPatterns.creational.factory.interfaces.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing " + this.getClass().getSimpleName());
    }
}
