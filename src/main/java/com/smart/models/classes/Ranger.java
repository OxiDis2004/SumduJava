package com.smart.models.classes;

public class Ranger extends CharacterClass {
    private final String perk;

    public Ranger() {
        super("Ranger", 10);
        this.perk = "Beast Master";
    }

    @Override
    public void printMagika() {
        System.out.println("Perk: " + this.perk);
    }
}
