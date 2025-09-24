package com.smart.Factory;

import java.util.List;

public class Bard extends CharacterClass {
    private List<String> spells;

    public Bard() {
        super("Bard", 8);
        this.spells = List.of("Charm Person", "Heroism");
    }

    @Override
    public void printMagika() {
        System.out.print("Spells: ");
        System.out.print(String.join(", ", spells));
    }
}
