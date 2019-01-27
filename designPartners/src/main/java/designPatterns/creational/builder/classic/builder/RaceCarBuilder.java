package designPatterns.creational.builder.classic.builder;

import designPatterns.creational.builder.classic.entities.Car;
import designPatterns.creational.builder.classic.entities.Engine;
import designPatterns.creational.builder.classic.entities.Tires;

public class RaceCarBuilder implements CarBuilder {

    private Car car;

    public RaceCarBuilder() {
        car = new Car();
    }

    @Override
    public void buildTires() {
        Tires tires = new Tires();
        tires.setType("Slicks");
        tires.setDurability(50);
        car.setTires(tires);
    }

    @Override
    public void buildEngine() {
        Engine engine = new Engine();
        engine.setType("v8");
        car.setEngine(engine);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
