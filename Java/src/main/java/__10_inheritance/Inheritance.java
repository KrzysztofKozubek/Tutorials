package __10_inheritance;

/*
 * What is inheritance was explain in _1_object_orientated_programming.core_oops._4_Inheritance.java
 *
 * Here we have example inheritance
 *
 * */

public class Inheritance {

    public Integer publicVariable = 1;
    protected Integer protectedVariable = 2;
    Integer variable = 3;
    private Integer privateVariable = 4;

    void toDo() {
        System.out.println("Inheritance");
    }

    @Override
    public String toString() {
        return "Inheritance{" +
                "publicVariable=" + publicVariable +
                ", protectedVariable=" + protectedVariable +
                ", variable=" + variable +
                ", privateVariable=" + privateVariable +
                '}';
    }
}

class Heir extends Inheritance {

    public Heir() {
        publicVariable = 2;
        protectedVariable = 3;
        variable = 4; // we have access bc, its the same package
//        privateVariable = 5; no access ;(
    }

    @Override
    void toDo() {
        super.toDo();
        System.out.println("Heir");
    }

    public static void main(String[] args) {
        System.out.println(new Inheritance());
        System.out.println(new Heir());
    }
}

interface A {

    void doIt();

    default void toDo() {
        System.out.println("A");
    }
}

interface B extends A {

    @Override
    default void toDo() {
        A.super.toDo(); // <- here we have access to interface A
        System.out.println("B");
    }
}

class Impl implements A, B {

    @Override
    public void doIt() {
        /*        A.super.toDo(); // <- here we haven't access to interface A */
        B.super.toDo();
        System.out.println("DO IT!");
    }

    public static void main(String[] args) {
        new Impl().doIt();
    }
}

class ImplAndHeir extends Heir implements A, B {

    @Override
    public void doIt() {
        super.toDo();
        B.super.toDo();
    }

    @Override
    public void toDo() {
        doIt();
    }

    public static void main(String[] args) {
        new ImplAndHeir().doIt();
    }
}