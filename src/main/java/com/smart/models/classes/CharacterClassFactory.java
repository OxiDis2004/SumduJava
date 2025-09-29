package com.smart.models.classes;

public class CharacterClassFactory {

    public static final String BARD = "Bard";
    public static final String RANGER = "Ranger";

    public static CharacterClass getClass(String type) {
        return switch (type) {
            case BARD -> new Bard();
            case RANGER -> new Ranger();
            default -> null;
        };
    }
}

