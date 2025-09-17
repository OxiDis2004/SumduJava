package com.smart.items.food;

import com.smart.items.Item;
import com.smart.packing.Packing;
import com.smart.packing.Wrapper;

public class Burger implements Item {

    @Override
    public String name() {
        return "Burger";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 1.5f;
    }
}
