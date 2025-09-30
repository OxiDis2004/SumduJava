package com.smart.memento;

import com.smart.models.stats.StatsName;

import java.util.HashMap;

public record Memento(HashMap<StatsName, Integer> state) {

    public Memento(HashMap<StatsName, Integer> state) {
        this.state = new HashMap<>(state);
    }
}
