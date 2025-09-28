package com.smart.races;

import com.smart.DataElement;
import com.smart.stats.Stats;
import com.smart.visitor.DataElementsVisitor;

import java.util.TreeMap;

public abstract class CharacterRace implements DataElement {
    private final String name;
    private final Stats bonuses;

    public CharacterRace(String name, Stats bonuses) {
        this.name = name;
        this.bonuses = bonuses;
    }

    public String getName() {
        return name;
    }

    public Stats getRaceBonuses() {
        return bonuses;
    }

    public void print() {
        System.out.println("Name: " + name + ", Bonuses: " );
        bonuses.print();
    }

    @Override
    public void accept(DataElementsVisitor visitor, TreeMap<String, Object> collector) {
        visitor.visit(this, collector);
    }

    public abstract void saySMTH();
}
