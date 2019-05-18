package __12_generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generics {

    public static <T> void cout(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }
}

/*
* The most commonly used type parameter names are:

    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types

*/

class GenericClass <T> {

    List<T> listType = new ArrayList<>();

    T method(T ele) {
        listType.add(ele);
        return ele;
    }

    <E> E method2(E ele, T type) {
        return ele;
    }

    <E> T method3(E ele, T type) {
        return type;
    }

    public static void main(String[] args) {
        GenericClass<String> g = new GenericClass<>();
        System.out.println(g.method("czx"));
        System.out.println(g.method2(new ArrayList<>(Collections.singletonList(new Object())), "czx"));
        System.out.println(g.method3(123, "123"));
    }
}

class ExtendsGenericClass <T extends Number> {
//    its mean u can use this class with Object and subclass of it
    public static void main(String[] args) {
        new ExtendsGenericClass<Integer>();
//        new ExtendsGenericClass<String>(); <- cannot do this
    }
}