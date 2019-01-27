package designPatterns.structural.bridge.toImpl;

import designPatterns.structural.bridge.interfaces.Bridge;
import designPatterns.structural.bridge.interfaces.Car;

public class SportCar implements Bridge {

    private Car car = new designPatterns.structural.bridge.impl.SportCar();

    public SportCar() {
    }

    @Override
    public void action() {
        car.turnOn();
        car.turnDown();
    }
}
