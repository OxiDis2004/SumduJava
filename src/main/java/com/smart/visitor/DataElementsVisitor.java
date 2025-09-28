package com.smart.visitor;

import com.smart.Character;
import com.smart.classes.CharacterClass;
import com.smart.races.CharacterRace;
import com.smart.stats.Stats;

import java.util.TreeMap;

public interface DataElementsVisitor {
    void visit(Character character, TreeMap<String, Object> collector);
    void visit(CharacterClass cClass, TreeMap<String, Object> collector);
    void visit(CharacterRace race, TreeMap<String, Object> collector);
    void visit(Stats stats, TreeMap<String, Object> collector);
}
