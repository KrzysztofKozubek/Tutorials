package _1_object.core_oops.encapsulation.example;

public class Inherit extends A {

    private void used() {
        this.publicMethod();
        this.protectedMethod();
        this.defaultMethod();

        new A().publicMethod();
        new A().protectedMethod();
        new A().defaultMethod();
    }
}
