package designPatterns.creational.builder;

import designPatterns.creational.builder.classic.Meal;
import designPatterns.creational.builder.classic.MealBuilder;

/*
* Builder is used when
* process creating object is complicated
* process creating object has many logic
* */
public class App {

    public static void main(String[] args) {

//        fluent builder
        Computer computer = Computer.ComputerBuilder.builder()
                .HDD("HDD")
                .RAM("RAM")
                .motherboard("motherboard")
                .graphicCard("graphicCard")
                .build();

        System.out.println(computer);

//        classic builder
        MealBuilder builder = new MealBuilder();
        Meal meal;
        meal = builder.prepareVegMeal();
        meal.showItems();
        System.out.println(meal.getCost());
        meal = builder.prepareNonVegMeal();
        meal.showItems();
        System.out.println(meal.getCost());
        meal = builder.prepareDoubeBurger();
        meal.showItems();
        System.out.println(meal.getCost());
    }
}
