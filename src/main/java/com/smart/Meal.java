package com.smart;

import com.smart.items.Item;

import java.util.ArrayList;

public class Meal {

    private final ArrayList<Item> items;

    public Meal() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        return items.stream().map(Item::price).reduce(0f, Float::sum);
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("Item: " + item.name() + " in " + item.packing() + " and cost " + item.price());
        }
    }
}
