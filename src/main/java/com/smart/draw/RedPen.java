package com.smart.draw;

public class RedPen implements DrawingAPI {
    @Override
    public void drawCircle(String position) {
        System.out.println("Drawing Red Circle: " + position);
    }
}
