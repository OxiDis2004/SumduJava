package com.smart.models.races;

import com.smart.models.DataElement;
import com.smart.models.stats.Stats;
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
        System.out.println("Name: " + name + ",\nBonuses: " );
        bonuses.print();
    }

    @Override
    public void accept(DataElementsVisitor visitor, TreeMap<String, Object> collector) {
        visitor.visit(this, collector);
    }

    public abstract void saySMTH();
}
