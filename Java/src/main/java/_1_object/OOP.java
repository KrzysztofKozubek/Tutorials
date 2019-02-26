package _1_object;

import java.math.BigDecimal;

public class OOP {}

/*
* Object orientated programming?
* - it mean only that, we r working on object in program.
* - objects r reflection real thing.
*
* Example:
*/
class Car {

    /*
    Car has attributes:
    - max speed
    - color
    - price
    - mark
    - model
    */

    private Integer maxSpeed;
    private String Color;
    private BigDecimal price;
    private String brand;
    private String model;

    /*
    * Each one this attribute present one information about presented car.
    * */

    /*
    * Otherwise we can do sth actions:
    * Example: */
    void turnOn() {
//        turn on the car
    }

    void turnOff() {
//        turn off the car
    }
}

/*
* Summary:
* Object is abstract represent the real thing:
* - Variable in the class is information about object
* - Methods r actions what we can do on object
*/