package com.smart;

import com.smart.memento.CareTaker;

public class Main {

    private static final Stats stats = new Stats();
    private static final CareTaker ct = new CareTaker();

    public static void main(String[] args) {
        Character character = new Character("Gremlin", "Dworg", getNewStats());
        character.printSheet();
        System.out.println();

        character.setAttribute(getNewStats());
        character.printSheet();
        System.out.println();

        character.setAttribute(getNewStats());
        character.printSheet();
        System.out.println();

        stats.getStateFromMemento(ct.get(0));
        character.setAttribute(stats);
        character.printSheet();
    }

    public static Stats getNewStats() {
        stats.generate();
        stats.print();
        ct.add(stats.saveStateToMemento());
        return stats;
    }
}