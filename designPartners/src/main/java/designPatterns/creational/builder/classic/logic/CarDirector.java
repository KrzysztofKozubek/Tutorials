package designPatterns.creational.builder.classic.logic;

import designPatterns.creational.builder.classic.builder.CarBuilder;
import designPatterns.creational.builder.classic.entities.Car;

public class CarDirector {

    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void makeCar() {
        carBuilder.buildEngine();
        carBuilder.buildTires();
    }

    public Car getCar() {
        return carBuilder.getCar();
    }
}
