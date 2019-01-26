package designPatterns.builder.classic.builder;

import designPatterns.builder.classic.entities.Car;

public abstract class CarBuilder2 {

    private Car car;

    abstract void buildTires();
    abstract void buildEngine();

    public Car getCar() {
        return car;
    }
}
