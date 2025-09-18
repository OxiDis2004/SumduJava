package com.smart;

import com.smart.shapes.Shape;

public class Main {
    public static void main(String[] args) {
        ShapeCache shapeCache = new ShapeCache();
        shapeCache.loadShape();
        System.out.println("ShapeCache loaded");
        System.out.println("----------------------");
        Shape s1 = shapeCache.getShape("c");
        System.out.println("Shape: " + s1.getType());
        Shape s2 = shapeCache.getShape("r");
        System.out.println("Shape: " + s2.getType());
        Shape s3 = shapeCache.getShape("s");
        System.out.println("Shape: " + s3.getType());
    }
}