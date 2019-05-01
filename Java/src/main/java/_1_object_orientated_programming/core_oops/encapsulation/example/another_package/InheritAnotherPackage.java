package _1_object_orientated_programming.core_oops.encapsulation.example.another_package;

import _1_object_orientated_programming.core_oops.encapsulation.example.A;

public class InheritAnotherPackage extends A {

    private void used() {
        this.publicMethod();
        this.protectedMethod();

        new A().publicMethod();
//        new A().protectedMethod(); haven't access
    }
}
