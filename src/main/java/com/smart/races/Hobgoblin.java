package com.smart.races;

import com.smart.stats.Stats;

public class Hobgoblin extends CharacterRace {

    public Hobgoblin(String name, Stats bonuses) {
        super(name, bonuses);
    }

    @Override
    public void saySMTH() {
        System.out.println("Hhrrr");
    }
}
