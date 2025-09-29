package com.smart.visitor;

import com.smart.models.Character;
import com.smart.models.classes.CharacterClass;
import com.smart.models.races.CharacterRace;
import com.smart.models.stats.Stats;
import java.util.TreeMap;

public class ElementVisitor implements DataElementsVisitor {

    @Override
    public void visit(Character character, TreeMap<String, Object> collector) {
        character.talk();
    }

    @Override
    public void visit(CharacterRace race, TreeMap<String, Object> collector) {
        race.print();
    }

    @Override
    public void visit(CharacterClass cClass, TreeMap<String, Object> collector) {
        System.out.println(cClass.toString());
        cClass.printMagika();
    }

    @Override
    public void visit(Stats stats, TreeMap<String, Object> collector) {
        stats.print();
    }
}
