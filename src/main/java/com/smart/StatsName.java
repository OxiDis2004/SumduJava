package com.smart;

public enum StatsName {
    STRENGTH("strength"),
    DEXTERITY("dexterity"),
    CONSTITUTION("constitution"),
    INTELLIGENCE("intelligence"),
    WISDOM("wisdom"),
    CHARISMA("charisma");

    private final String name;

    StatsName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
