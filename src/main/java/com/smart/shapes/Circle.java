package com.smart.shapes;

public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    public Circle(Circle circle) {
        this.type = circle.getType() + " clone";
    }

    @Override
    public Object clone() {
        return new Circle(this);
    }
}
