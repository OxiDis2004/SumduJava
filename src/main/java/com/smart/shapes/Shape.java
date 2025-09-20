package com.smart.shapes;

import com.smart.draw.DrawingAPI;

public abstract class Shape {

    protected DrawingAPI drawingAPI;

    public Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
}
