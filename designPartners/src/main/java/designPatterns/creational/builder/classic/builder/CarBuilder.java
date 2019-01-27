package designPatterns.creational.builder.classic.builder;

import designPatterns.creational.builder.classic.entities.Car;

public interface CarBuilder {
    void buildTires();
    void buildEngine();
    Car getCar();
}
