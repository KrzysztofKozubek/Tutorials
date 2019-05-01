package _3_constructor.enum_constructor;

public enum Base {
    MON(false), TWO(false), SUN(true);

    public static Boolean freeDay;

    Base(Boolean freeDay) {
        freeDay = freeDay;
    }
}

interface B {
    void doIt();
}

enum A implements B {
    A, B, C, D, E;

    @Override
    public void doIt() {
    }
}