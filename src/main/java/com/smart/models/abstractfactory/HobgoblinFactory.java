package com.smart.models.abstractfactory;

import com.smart.models.races.CharacterRace;
import com.smart.models.races.Hobgoblin;
import com.smart.models.stats.Stats;
import com.smart.models.stats.StatsName;

public class HobgoblinFactory implements RaceAbstractFactory {

    private final String name = "Hobgoblin";

    @Override
    public CharacterRace create() {
        Stats bonuses = new Stats();
        bonuses.state.put(StatsName.DEXTERITY, 2);
        bonuses.state.put(StatsName.CONSTITUTION, 1);
        return new Hobgoblin(name, bonuses);
    }

    @Override
    public String name() {
        return name;
    }
}
