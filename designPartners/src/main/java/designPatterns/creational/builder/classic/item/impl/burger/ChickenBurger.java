package designPatterns.creational.builder.classic.item.impl.burger;

import designPatterns.creational.builder.classic.item.impl.Burger;

public class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public Double price() {
        return 4.;
    }
}
