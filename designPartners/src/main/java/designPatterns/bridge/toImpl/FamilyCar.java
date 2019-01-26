package designPatterns.bridge.toImpl;

import designPatterns.bridge.interfaces.Bridge;
import designPatterns.bridge.interfaces.Car;

public class FamilyCar implements Bridge {

    private Car car = new designPatterns.bridge.impl.FamilyCar();

    public FamilyCar() {
    }

    @Override
    public void action() {
        car.turnOn();
        car.turnDown();
    }
}
