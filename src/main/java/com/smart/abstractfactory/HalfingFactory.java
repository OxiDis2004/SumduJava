package com.smart.abstractfactory;

import com.smart.races.CharacterRace;
import com.smart.races.Halfing;
import com.smart.stats.Stats;
import com.smart.stats.StatsName;

public class HalfingFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        Stats bonuses = new Stats();
        bonuses.state.put(StatsName.DEXTERITY, 2);
        bonuses.state.put(StatsName.CONSTITUTION, 1);
        return new Halfing("Halfing", bonuses);
    }
}
