package designPatterns.factory.impl;

import designPatterns.factory.interfaces.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing " + this.getClass().getSimpleName());
    }
}
