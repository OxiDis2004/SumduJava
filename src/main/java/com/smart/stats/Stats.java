package com.smart.stats;

import java.util.HashMap;

public class Stats {

    public HashMap<StatsName, Integer> state = new HashMap<>();

    public Stats generate() {
        Dice dice = new Dice();
        state.put(StatsName.STRENGTH, dice.rollStat());
        state.put(StatsName.DEXTERITY, dice.rollStat());
        state.put(StatsName.CONSTITUTION, dice.rollStat());
        state.put(StatsName.INTELLIGENCE, dice.rollStat());
        state.put(StatsName.WISDOM, dice.rollStat());
        state.put(StatsName.CHARISMA, dice.rollStat()); 
        return this;
    }

    public void print() {
        for (var entry : state.entrySet()) {
            System.out.printf("%s: %s%n", entry.getKey().getName(), entry.getValue());
        }
    }
}
