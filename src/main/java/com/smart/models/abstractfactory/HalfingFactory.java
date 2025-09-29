package com.smart.models.abstractfactory;

import com.smart.models.races.CharacterRace;
import com.smart.models.races.Halfing;
import com.smart.models.stats.Stats;
import com.smart.models.stats.StatsName;

public class HalfingFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        Stats bonuses = new Stats();
        bonuses.state.put(StatsName.DEXTERITY, 2);
        bonuses.state.put(StatsName.CONSTITUTION, 1);
        return new Halfing("Halfing", bonuses);
    }
}
