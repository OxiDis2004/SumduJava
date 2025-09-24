package com.smart.classes;

import com.smart.DataElement;
import com.smart.visitor.DataElementsVisitor;

public abstract class CharacterClass implements DataElement {
    private final String name;
    private final int hp;

    public CharacterClass(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public int getHP() {
        return hp;
    }

    public String toString() {
        return String.format("Name: %s, HP: %d", name, hp);
    }

    @Override
    public void accept(DataElementsVisitor visitor) {
        visitor.visit(this);
    }

    public abstract void printMagika();
}

