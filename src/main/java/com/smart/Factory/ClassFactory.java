package com.smart.Factory;

public class ClassFactory {
    public CharacterClass getClass(String type) {
        return switch (type) {
            case "Bard" -> new Bard();
            case "Ranger" -> new Ranger();
            default -> null;
        };
    }
}
