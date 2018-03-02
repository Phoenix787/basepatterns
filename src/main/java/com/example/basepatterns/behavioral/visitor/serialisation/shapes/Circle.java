package com.example.basepatterns.behavioral.visitor.serialisation.shapes;

import com.example.basepatterns.behavioral.visitor.serialisation.visitor.Visitor;

public class Circle extends Dot {
    public int radius;

    public Circle(int x, int y, int id, int radius) {
        super(x, y, id);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }

    public int getRadius() {
        return radius;
    }
}
