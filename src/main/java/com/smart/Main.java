package com.smart;

public class Main {
    public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();
        facade.getAllShapeInCache();
        System.out.println("------------------");
        facade.getCircle();
        facade.getRectangle();
        facade.getSquare();
    }
}