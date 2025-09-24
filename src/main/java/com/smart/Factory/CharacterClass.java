package com.smart.Factory;

public abstract class CharacterClass {
    private String name;
    private int hp;

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

    public abstract void printMagika();
}
