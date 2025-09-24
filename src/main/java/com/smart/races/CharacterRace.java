package com.smart.races;

import com.smart.stats.Stats;

public abstract class CharacterRace {
    private final String name;
    private final Stats bonuses;

    public CharacterRace(String name, Stats bonuses) {
        this.name = name;
        this.bonuses = bonuses;
    }

    public Stats getRaceBonuses() {
        return bonuses;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Bonuses: ");
        bonuses.print();
    }

    public abstract void saySMTH();
}
