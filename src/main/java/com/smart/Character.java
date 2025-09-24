package com.smart;

import com.smart.Factory.Bard;
import com.smart.Factory.CharacterClass;
import com.smart.Factory.Ranger;

public class Character {
    private String name;
    private CharacterClass chClass;
    private Stats attributes;
    private int hp;

    public Character(String name, CharacterClass chClass, Stats attributes) {
        this.name = name;
        this.chClass = chClass;
        this.attributes = attributes;
    }

    public void addBonuses() {
        this.hp = (int) (chClass.getHP() + (double) (attributes.state.get(StatsName.CONSTITUTION) / 2) - 5);
    }

    public void talk() {
        if (this.chClass instanceof Bard) {
            System.out.println(this.name + " is a Bard");
        } else if (this.chClass instanceof Ranger) {
            System.out.println(this.name + " is a Ranger");
        }
        System.out.println("HP: " + this.hp);
        chClass.printMagika();
    }
}
