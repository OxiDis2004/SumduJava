package com.smart.shapes;

public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    public Square(Square square) {
        type = square.getType() + " clone";
    }

    @Override
    public Object clone() {
        return new Square(this);
    }
}
