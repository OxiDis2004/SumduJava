package com.smart;

import com.smart.visitor.DataElementsVisitor;

public interface DataElement {
    void accept(DataElementsVisitor visitor);
}
