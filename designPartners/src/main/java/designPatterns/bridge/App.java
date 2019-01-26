package designPatterns.bridge;

import designPatterns.bridge.toImpl.FamilyCar;
import designPatterns.bridge.interfaces.Bridge;
import designPatterns.bridge.toImpl.SportCar;

/*
* Bridge is used when
* have to separate interface with implementation
* interface and impl have to be expended
* change impl has not impact of client
* */
public class App {

    public static void main(String[] args) {
        Bridge bridge = new FamilyCar();
        bridge.action();
        bridge = new SportCar();
        bridge.action();
    }
}
