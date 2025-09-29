package com.smart.models.stats;

import com.smart.models.DataElement;
import com.smart.visitor.DataElementsVisitor;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

public class Stats implements DataElement {

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

    @Override
    public void accept(DataElementsVisitor visitor, TreeMap<String, Object> collector) {
        visitor.visit(this, collector);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return Objects.equals(state, stats.state);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(state);
    }
}
