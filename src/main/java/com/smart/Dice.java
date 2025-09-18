package com.smart;

import java.util.Arrays;
import java.util.Random;

public class Dice {
    public int roll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public int rollStat() {
        int[] stat = { 0, 0, 0 };
        for (int i = 0; i < 6; i++) {
            int rolled = roll();
            for (int j = 0; j < stat.length; j++) {
                stat[j] = Math.max(rolled, stat[j]);
            }
        }
        return Arrays.stream(stat).sum();
    }
}
