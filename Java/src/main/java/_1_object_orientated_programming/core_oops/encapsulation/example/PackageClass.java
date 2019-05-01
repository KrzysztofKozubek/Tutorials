package _1_object_orientated_programming.core_oops.encapsulation.example;

import _1_object_orientated_programming.core_oops.encapsulation.example.another_package.B;

public class PackageClass {

    public void publicMethod() {
        System.out.println("public method");
    }

    protected void protectedMethod() {
        System.out.println("protected method");
    }

    void defaultMethod() {
        System.out.println("default (package-private) method");
    }

    private void privateMethod() {
        System.out.println("private method");
    }

    private void used() {
        this.publicMethod();
        this.protectedMethod();
        this.defaultMethod();
        this.privateMethod();

        new A().publicMethod();
        new A().protectedMethod();
        new A().defaultMethod();

        new B().publicMethod();
    }
}
