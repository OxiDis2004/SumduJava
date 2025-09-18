package com.smart;

public class Character {
    private String name;
    private String dndclass;
    private Stats attributes;

    public Character(String name, String dndclass, Stats attributes) {
        this.name = name;
        this.dndclass = dndclass;
        this.attributes = attributes;
    }

    public void setAttribute(Stats attributes) {
        this.attributes = attributes;
    }

    public void printSheet() {
        System.out.println("Name: " + name);
        System.out.println("Dnd class: " + dndclass);
        attributes.print();
    }
}
