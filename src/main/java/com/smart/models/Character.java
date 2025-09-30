package com.smart.models;

import com.smart.models.classes.CharacterClass;
import com.smart.models.races.CharacterRace;
import com.smart.models.stats.Stats;
import com.smart.visitor.DataElementsVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Character implements DataElement {
    private final String name;
    private int hp;

    private final List<DataElement> items = new ArrayList<>();

    public Character(String name, CharacterRace race, CharacterClass cClass, Stats attributes) {
        this.name = name;

        items.add(race);
        items.add(cClass);
        items.add(attributes);
    }

    public String getName() {
        return name;
    }

    public CharacterRace getRace() {
        return (CharacterRace) this.items.getFirst();
    }

    public CharacterClass getCharacterClass() {
        return (CharacterClass) this.items.get(1);
    }

    public Stats getAttributes() {
        return (Stats) this.items.get(2);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String info() {
        return "Name: " + this.name + ", HP: " + this.hp + "\n"
                + "race: " + getRace().info() + "\n"
                + " has:\n" + getAttributes().toString() + "\n"
                + getCharacterClass().printMagika();
    }

    @Override
    public void accept(DataElementsVisitor visitor, TreeMap<String, Object> collector) {
        visitor.visit(this, collector);
    }
}
