package com.smart;

import com.smart.abstractfactory.HalfingFactory;
import com.smart.classes.ClassFactory;
import com.smart.stats.Stats;
import com.smart.visitor.ElementVisitor;

public class Main {
    private final static ElementVisitor elementVisitor = new ElementVisitor();

    public static void main(String[] args) {
        Character unit = new Character(
                "Abrams",
                new HalfingFactory().create(),
                new ClassFactory().getClass("Ranger"),
                new Stats().generate()
        );

        unit.accept(elementVisitor);
        System.out.println();
        unit.getRace().accept(elementVisitor);
        System.out.println();
        unit.getCharacterClass().accept(elementVisitor);
        System.out.println();
        unit.getAttributes().accept(elementVisitor);
    }
}