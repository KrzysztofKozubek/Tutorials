package _3_constructor.enum_constructor;

public enum Base {
    MON(false), TWO(false), SUN(true);

    private Boolean freeDay;

    Base(Boolean freeDay) {
        this.freeDay = freeDay;
    }

    public Boolean getFreeDay() {
        return freeDay;
    }
}

interface B {
    void doIt();
}

enum A implements B {
    A, B, C, D, E;

    @Override
    public void doIt() {
        System.out.println(Base.MON.getFreeDay());
    }
}