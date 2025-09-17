package com.smart.items;

import com.smart.packing.Packing;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
