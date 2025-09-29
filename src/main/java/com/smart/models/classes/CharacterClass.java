package com.smart.models.classes;

import com.smart.models.DataElement;
import com.smart.visitor.DataElementsVisitor;

import java.util.TreeMap;

public abstract class CharacterClass implements DataElement {
    private final String name;
    private final int hp;

    public CharacterClass(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public String toString() {
        return String.format("Name: %s, HP: %d", name, hp);
    }

    @Override
    public void accept(DataElementsVisitor visitor, TreeMap<String, Object> collector) {
        visitor.visit(this, collector);
    }

    public abstract void printMagika();
}

