package designPatterns.structural.bridge.impl;

import designPatterns.structural.bridge.interfaces.Car;

public class SportCar implements Car {

    @Override
    public void turnOn() {
        System.out.println("SportCar::turnOn");
    }

    @Override
    public void turnDown() {
        System.out.println("SportCar::turnDown");
    }
}
