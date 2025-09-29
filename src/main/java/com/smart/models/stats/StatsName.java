package com.smart.models.stats;

public enum StatsName {
    STRENGTH("Strength"),
    DEXTERITY("Dexterity"),
    CONSTITUTION("Constitution"),
    INTELLIGENCE("Intelligence"),
    WISDOM("Wisdom"),
    CHARISMA("Charisma");

    private final String name;

    StatsName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
