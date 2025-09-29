package com.smart.models.classes;

import java.util.List;

public class Bard extends CharacterClass {
    private final List<String> spells;

    public Bard() {
        super("Bard", 8);
        this.spells = List.of("Charm Person", "Heroism");
    }

    @Override
    public void printMagika() {
        System.out.print("Spells: ");
        System.out.println(String.join(", ", spells));
    }
}
