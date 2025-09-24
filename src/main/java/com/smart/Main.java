package com.smart;

import com.smart.Factory.CharacterClass;
import com.smart.Factory.ClassFactory;

public class Main {
    public final static ClassFactory classFactory = new ClassFactory();

    public static Character generateCharacter(String type, String name) {
        CharacterClass characterClass = classFactory.getClass(type);
        Stats stats = new Stats().generate();
        Character ch = new Character(name, characterClass, stats);
        ch.addBonuses();
        return ch;
    }

    public static void main(String[] args) {
        Character ranger = generateCharacter("Ranger", "Achsil");
        ranger.talk();
        System.out.println();
        Character bard = generateCharacter("Bard", "Maskil");
        bard.talk();
    }
}