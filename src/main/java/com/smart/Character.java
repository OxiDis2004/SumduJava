package com.smart;

import com.smart.classes.CharacterClass;
import com.smart.races.CharacterRace;
import com.smart.stats.Stats;
import com.smart.visitor.DataElementsVisitor;

import java.util.ArrayList;
import java.util.List;

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

    public void talk() {
        System.out.print(this.name + " says ");
        getRace().saySMTH();
        System.out.println(this.name + " has:");
        getAttributes().print();
        getCharacterClass().printMagika();
    }

    @Override
    public void accept(DataElementsVisitor visitor) {
        visitor.visit(this);
    }
}
