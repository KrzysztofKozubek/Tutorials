package designPatterns.bridge;

import designPatterns.bridge.toImpl.FamilyCar;
import designPatterns.bridge.interfaces.Bridge;
import designPatterns.bridge.toImpl.SportCar;

public class App {

    public static void main(String[] args) {
        Bridge bridge = new FamilyCar();
        bridge.action();
        bridge = new SportCar();
        bridge.action();
    }
}
