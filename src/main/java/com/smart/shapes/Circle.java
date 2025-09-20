package com.smart.shapes;

import com.smart.draw.DrawingAPI;

public class Circle extends Shape {

    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawingAPI.drawCircle(String.format("x=%s, y=%s, radius=%s", x, y, radius));
    }
}
