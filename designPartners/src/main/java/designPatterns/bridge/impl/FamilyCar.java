package designPatterns.bridge.impl;

import designPatterns.bridge.interfaces.Car;

public class FamilyCar implements Car {

    @Override
    public void turnOn() {
        System.out.println("FamilyCar::turnOn");
    }

    @Override
    public void turnDown() {
        System.out.println("FamilyCar::turnDown");
    }
}
