package designPatterns.creational.builder.classic;

import designPatterns.creational.builder.classic.item.Item;

import java.util.LinkedList;
import java.util.List;

public class Meal {
    private List<Item> items = new LinkedList<>();

    void addItem(Item item) {
        items.add(item);
    }

    public Double getCost() {
        return items.stream()
                .mapToDouble(Item::price)
                .sum();
    }

    public void showItems() {
        items.forEach(
                item -> System.out.println("Item: " + item.name() + " " + item.price())
        );
    }
}
