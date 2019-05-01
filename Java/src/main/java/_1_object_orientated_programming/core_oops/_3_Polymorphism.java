package _1_object_orientated_programming.core_oops;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
* Polymorphism is the concept where an object behaves differently in different situation.
 * There two types of polymorphism:
 * - compile time
 * - runtime
 *
 * Example:
 * - Compile time*/
public class _3_Polymorphism {

    void main () {}
    void main (String s) {}
    void main (String[] args) {}
    /*
    polymorphism compile time occurs when we overloading method
    (multiple implementation with different argument)
    */


    /*
    * Runtime example
    * */

    private List<String> list;

    void init() {
        if (new Random().nextBoolean()) {
            list = new ArrayList<>();
        } else {
            list = new LinkedList<>();
        }
    }
    /* during compilation we don't know what we used */
}


