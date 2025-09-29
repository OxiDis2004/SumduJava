package com.smart.visitor;

import com.smart.models.Character;
import com.smart.models.classes.CharacterClass;
import com.smart.models.races.CharacterRace;
import com.smart.models.stats.Stats;

import java.util.TreeMap;

public class SaveVisitor implements DataElementsVisitor {
    @Override
    public void visit(Character character, TreeMap<String, Object> collector) {
        collector.put("name", character.getName());
        collector.put("raceName", character.getRace().getName());
        collector.put("raceBonuses", character.getRace().getRaceBonuses().state);
        collector.put("className", character.getCharacterClass().getName());
        collector.put("hp", character.getHp());
        collector.put("stats", character.getAttributes().state);
    }

    @Override
    public void visit(CharacterClass cClass, TreeMap<String, Object> collector) {
        collector.put("name", cClass.getName());
        collector.put("hp", cClass.getHP());
    }

    @Override
    public void visit(CharacterRace race, TreeMap<String, Object> collector) {
        collector.put("name", race.getName());
        collector.put("bonuses", race.getRaceBonuses().state);
    }

    @Override
    public void visit(Stats stats, TreeMap<String, Object> collector) {
        collector.put("stats", stats.state);
    }
}
