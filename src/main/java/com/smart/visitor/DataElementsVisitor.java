package com.smart.visitor;

import com.smart.models.Character;
import com.smart.models.classes.CharacterClass;
import com.smart.models.races.CharacterRace;
import com.smart.models.stats.Stats;

import java.util.TreeMap;

public interface DataElementsVisitor {
    void visit(Character character, TreeMap<String, Object> collector);
    void visit(CharacterClass cClass, TreeMap<String, Object> collector);
    void visit(CharacterRace race, TreeMap<String, Object> collector);
    void visit(Stats stats, TreeMap<String, Object> collector);
}
