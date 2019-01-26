package designPatterns.facade;

public class App {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doSthSubSystem1();
        facade.doSthSubSystem2();
        facade.doSthAllSubSystems();
    }
}
