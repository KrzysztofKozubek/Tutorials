package designPatterns.builder.classic.builder;

import designPatterns.builder.classic.entities.Car;

public interface CarBuilder {
    void buildTires();
    void buildEngine();
    Car getCar();
}
