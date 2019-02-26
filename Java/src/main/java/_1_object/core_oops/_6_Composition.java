package _1_object.core_oops;

import java.util.List;

/*
* Composition is a special case of aggregation.
* We r using it when object has a object
*
* Example: */
public class _6_Composition {
}

/* House has rooms */
class House {
    List<Room> rooms;
}
class Room {}

/* Advantages:
 * + control object
 * + reuse the same object
 * + use less memory
 *
 * Disadvantages:
 * - makes it difficult to create unit tests
 * - makes it difficult debug
 * */