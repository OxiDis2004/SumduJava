package com.smart;

import com.smart.draw.GreenPen;
import com.smart.draw.RedPen;
import com.smart.shapes.Circle;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Circle redCircle = new Circle(10, 10, 4, new RedPen());
        redCircle.draw();

        Circle greenCircle = new Circle(20, 15, 3, new GreenPen());
        greenCircle.draw();
    }
}