package com.smart;

import com.smart.shapes.Circle;
import com.smart.shapes.Rectangle;
import com.smart.shapes.Shape;
import com.smart.shapes.Square;

import java.util.HashMap;

public class ShapeCache {
    private final HashMap<String, Shape> shapeMap = new HashMap<>();

    public Shape getShape(String id) {
        Shape shape = shapeMap.getOrDefault(id, null);
        return shape != null ? (Shape) shape.clone() : null;
    }

    public void loadShape() {
        Circle c = new Circle();
        c.setId("c");
        shapeMap.put(c.getId(), c);
        Rectangle r = new Rectangle();
        r.setId("r");
        shapeMap.put(r.getId(), r);
        Square s = new Square();
        s.setId("s");
        shapeMap.put(s.getId(), s);
    }
}
