package designPatterns.creational.builder.classic.item.impl;

import designPatterns.creational.builder.classic.item.Item;

public abstract class Drink implements Item {
    @Override
    public String name() {
        return "Drink";
    }

    @Override
    public abstract Double price();
}
