package com.smart;

import com.smart.memento.Memento;

public class Stats {

    private String state;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        state = strength + " " + dexterity + " " +
                constitution + " " + intelligence + " " +
                wisdom + " " + charisma;
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        String[] stats = state.split(" ");
        if (stats.length == 6) {
            strength = Integer.parseInt(stats[0]);
            dexterity = Integer.parseInt(stats[1]);
            constitution = Integer.parseInt(stats[2]);
            intelligence = Integer.parseInt(stats[3]);
            wisdom = Integer.parseInt(stats[4]);
            charisma = Integer.parseInt(stats[5]);
        }
    }

    public Stats generate() {
        Dice dice = new Dice();
        strength = dice.rollStat();
        dexterity = dice.rollStat();
        constitution = dice.rollStat();
        intelligence = dice.rollStat();
        wisdom = dice.rollStat();
        charisma = dice.rollStat();
        return this;
    }

    public void print() {
        System.out.println("strength=" + strength + ", dexterity=" + dexterity + ", constitution=" + constitution +
                ", intelligence=" + intelligence + ", wisdom=" + wisdom + ", charisma=" + charisma);
    }
}
