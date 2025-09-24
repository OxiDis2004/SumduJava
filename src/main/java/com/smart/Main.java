package com.smart;

import com.smart.abstractfactory.HalfingFactory;
import com.smart.abstractfactory.HobgoblinFactory;
import com.smart.abstractfactory.RaceAbstractFactory;
import com.smart.races.CharacterRace;
import com.smart.stats.Stats;

public class Main {

    public static Character generate(RaceAbstractFactory factory, String name) {
        CharacterRace race = factory.create();
        Stats stats = new Stats().generate();
        Character ch = new Character(name, race, stats);
        ch.addRaceBonuses();
        return ch;
    }

    public static void main(String[] args) {
        generate(new HobgoblinFactory(), "Gagamaru").talk();
        System.out.println();
        generate(new HalfingFactory(), "German").talk();
    }
}