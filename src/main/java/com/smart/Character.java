package com.smart;

import com.smart.races.CharacterRace;
import com.smart.stats.Stats;

public record Character(String name, CharacterRace race, Stats attributes) {

    public void addRaceBonuses() {
        attributes.state.forEach((statName, statValue) -> attributes.state.put(statName, statValue + race.getRaceBonuses().state.getOrDefault(statName, 0)));
    }

    public void talk() {
        System.out.print(this.name + " says ");
        race.saySMTH();
        System.out.println(this.name + " has:");
        attributes.print();
    }
}
