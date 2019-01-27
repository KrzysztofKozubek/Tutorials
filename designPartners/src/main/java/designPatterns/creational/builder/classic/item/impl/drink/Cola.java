package designPatterns.creational.builder.classic.item.impl.drink;

import designPatterns.creational.builder.classic.item.impl.Drink;

public class Cola extends Drink {
    @Override
    public String name() {
        return "Cola";
    }

    @Override
    public Double price() {
        return 2.5;
    }
}
