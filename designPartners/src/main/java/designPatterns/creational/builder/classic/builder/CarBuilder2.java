package designPatterns.creational.builder.classic.builder;

import designPatterns.creational.builder.classic.entities.Car;

public abstract class CarBuilder2 {

    private Car car;

    abstract void buildTires();
    abstract void buildEngine();

    public Car getCar() {
        return car;
    }
}
