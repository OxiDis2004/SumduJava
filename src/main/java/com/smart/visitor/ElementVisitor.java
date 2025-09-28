package com.smart.visitor;

import com.smart.Character;
import com.smart.classes.CharacterClass;
import com.smart.races.CharacterRace;
import com.smart.stats.Stats;
import com.smart.stats.StatsName;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ElementVisitor implements DataElementsVisitor {

    @Override
    public void visit(Character character, TreeMap<String, Object> collector) {
        Map<StatsName, Integer> updated = new HashMap<>();

        character.getAttributes()
                .state
                .forEach((statsName, value) -> {
                    int bonus = character.getRace()
                            .getRaceBonuses()
                            .state
                            .getOrDefault(statsName, 0);
                    updated.put(statsName, value + bonus);
                });

        character.getAttributes().state.putAll(updated);

        int newHP = (int) (character.getCharacterClass().getHP() + (double) (character.getAttributes().state.get(StatsName.CONSTITUTION) / 2) - 5);
        character.setHp(newHP);
        character.talk();
    }

    @Override
    public void visit(CharacterRace race, TreeMap<String, Object> collector) {
        race.print();
    }

    @Override
    public void visit(CharacterClass cClass, TreeMap<String, Object> collector) {
        System.out.println(cClass.toString());
    }

    @Override
    public void visit(Stats stats, TreeMap<String, Object> collector) {
        stats.print();
    }
}
