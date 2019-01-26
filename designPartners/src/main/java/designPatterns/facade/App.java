package designPatterns.facade;

/*
* Facade is used when
* share simple interface
* add next abstract level
* */
public class App {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doSthSubSystem1();
        facade.doSthSubSystem2();
        facade.doSthAllSubSystems();
    }
}
