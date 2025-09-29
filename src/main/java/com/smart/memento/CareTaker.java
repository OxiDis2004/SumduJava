package com.smart.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private final List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

    public List<Memento> getList() {
        return mementoList;
    }

    public void remove(int index) {
        mementoList.remove(index);
    }
}
