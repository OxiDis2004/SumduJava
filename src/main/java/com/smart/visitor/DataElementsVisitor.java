package com.smart.visitor;

import com.smart.Character;
import com.smart.classes.CharacterClass;
import com.smart.races.CharacterRace;
import com.smart.stats.Stats;

public interface DataElementsVisitor {
    void visit(Character character);
    void visit(CharacterClass cClass);
    void visit(CharacterRace race);
    void visit(Stats stats);
}
