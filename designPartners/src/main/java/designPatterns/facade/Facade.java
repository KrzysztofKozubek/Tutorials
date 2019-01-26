package designPatterns.facade;

public class Facade {

    private SubSystem1 subSystem1;
    private SubSystem2 subSystem2;

    public Facade() {
        subSystem1 = new SubSystem1();
        subSystem2 = new SubSystem2();
    }

    public void doSthSubSystem1() {
        subSystem1.doSth();
    }

    public void doSthSubSystem2() {
        subSystem2.doSth();
    }

    public void doSthAllSubSystems() {
        doSthSubSystem1();
        doSthSubSystem2();
    }
}
