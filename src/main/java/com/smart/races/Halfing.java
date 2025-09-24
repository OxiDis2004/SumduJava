package com.smart.races;

import com.smart.stats.Stats;

public class Halfing extends CharacterRace {

    public Halfing(String name, Stats bonuses) {
        super(name, bonuses);
    }

    @Override
    public void saySMTH() {
        System.out.println("Hey body");
    }
}
