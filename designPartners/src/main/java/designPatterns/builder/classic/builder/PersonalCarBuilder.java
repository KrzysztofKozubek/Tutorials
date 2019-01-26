package designPatterns.builder.classic.builder;

import designPatterns.builder.classic.entities.Car;
import designPatterns.builder.classic.entities.Engine;
import designPatterns.builder.classic.entities.Tires;

public class PersonalCarBuilder implements CarBuilder {

    private Car car;

    public PersonalCarBuilder() {
        car = new Car();
    }

    @Override
    public void buildTires() {
        Tires tires = new Tires();
        tires.setType("Slicks");
        tires.setDurability(70);
        car.setTires(tires);
    }

    @Override
    public void buildEngine() {
        Engine engine = new Engine();
        engine.setType("v6");
        car.setEngine(engine);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
