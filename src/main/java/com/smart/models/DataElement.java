package com.smart.models;

import com.smart.visitor.DataElementsVisitor;

import java.util.TreeMap;

public interface DataElement {
    void accept(DataElementsVisitor visitor, TreeMap<String, Object> collector);
}
