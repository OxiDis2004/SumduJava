package com.smart.models.races;

import com.smart.models.stats.Stats;

public class Halfing extends CharacterRace {

    public Halfing(String name, Stats bonuses) {
        super(name, bonuses);
    }

    @Override
    public void saySMTH() {
        System.out.println("Hey body");
    }
}
