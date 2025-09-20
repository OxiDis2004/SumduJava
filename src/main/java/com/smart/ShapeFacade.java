package com.smart;

import com.smart.shapes.Shape;

public class ShapeFacade {

    private final static ShapeCache shapeCache = new ShapeCache();

    public ShapeFacade() {
        shapeCache.loadShape();
        System.out.println("ShapeCache loaded");
        System.out.println("---------------------");
    }

    public void getAllShapeInCache() {
        getCircle();
        getRectangle();
        getSquare();
    }

    public void getCircle() {
        getShape("c");
    }

    public void getRectangle() {
        getShape("r");
    }

    public void getSquare() {
        getShape("s");
    }

    private void getShape(String id) {
        Shape s = shapeCache.getShape(id);
        System.out.println("Shape: " + s.getType());
    }
}
