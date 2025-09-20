package com.smart.draw;

public class GreenPen implements DrawingAPI {
    @Override
    public void drawCircle(String position) {
        System.out.println("Drawing Green Circle: " + position);
    }
}
