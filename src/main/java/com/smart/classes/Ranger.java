package com.smart.classes;

public class Ranger extends CharacterClass {
    private String perk;

    public Ranger() {
        super("Ranger", 10);
        this.perk = "Beast Master";
    }

    @Override
    public void printMagika() {
        System.out.println("Perk: " + this.perk);
    }
}
