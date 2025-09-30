package com.smart.models.classes;

public class Ranger extends CharacterClass {
    private final String perk;

    public Ranger() {
        super("Ranger", 10);
        this.perk = "Beast Master";
    }

    @Override
    public String printMagika() {
        return "Perk: " + this.perk;
    }
}
