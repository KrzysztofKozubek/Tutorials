package designPatterns.creational.builder.classic;

import designPatterns.creational.builder.classic.item.impl.burger.ChickenBurger;
import designPatterns.creational.builder.classic.item.impl.burger.VegBurger;
import designPatterns.creational.builder.classic.item.impl.drink.Cola;
import designPatterns.creational.builder.classic.item.impl.drink.Pepsi;

public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Cola());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public Meal prepareDoubeBurger() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new ChickenBurger());
        meal.addItem(new Cola());
        return meal;
    }
}
