package com.smart.shapes;

public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    public Rectangle(Rectangle rectangle) {
        this.type = rectangle.getType() + " clone";
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
}
