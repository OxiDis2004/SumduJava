package com.smart.items.drink;

import com.smart.items.Item;
import com.smart.packing.Bottle;
import com.smart.packing.Packing;

public class ColdDrink implements Item {
    @Override
    public String name() {
        return "Cold drink";
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float price() {
        return 0.7f;
    }
}
