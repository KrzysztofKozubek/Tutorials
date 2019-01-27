package designPatterns.structural.bridge.toImpl;

import designPatterns.structural.bridge.interfaces.Bridge;
import designPatterns.structural.bridge.interfaces.Car;

public class FamilyCar implements Bridge {

    private Car car = new designPatterns.structural.bridge.impl.FamilyCar();

    public FamilyCar() {
    }

    @Override
    public void action() {
        car.turnOn();
        car.turnDown();
    }
}
