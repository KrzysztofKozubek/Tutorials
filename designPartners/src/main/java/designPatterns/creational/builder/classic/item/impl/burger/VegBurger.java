package designPatterns.creational.builder.classic.item.impl.burger;

import designPatterns.creational.builder.classic.item.impl.Burger;

public class VegBurger extends Burger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public Double price() {
        return 3.;
    }
}
