package designPatterns.creational.builder.classic.item.impl.drink;

import designPatterns.creational.builder.classic.item.impl.Drink;

public class Pepsi extends Drink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public Double price() {
        return 2.4;
    }
}
