package designPatterns.creational.builder.classic.item.impl;

import designPatterns.creational.builder.classic.item.Item;

public abstract class Burger implements Item {
    @Override
    public String name() {
        return "Burger";
    }

    @Override
    public abstract Double price();
}
