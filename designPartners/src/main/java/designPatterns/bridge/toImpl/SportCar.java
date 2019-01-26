package designPatterns.bridge.toImpl;

import designPatterns.bridge.interfaces.Bridge;
import designPatterns.bridge.interfaces.Car;

public class SportCar implements Bridge {

    private Car car = new designPatterns.bridge.impl.SportCar();

    public SportCar() {
    }

    @Override
    public void action() {
        car.turnOn();
        car.turnDown();
    }
}
