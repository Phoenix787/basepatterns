package com.example.basepatterns.behavioral.visitor.serialisation.shapes;

import com.example.basepatterns.behavioral.visitor.serialisation.visitor.Visitor;

public class Dot implements Shape {
    public int x;
    public int y;
    public int id;

    public Dot() {
    }

    public Dot(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        //move shape
    }

    @Override
    public void draw() {
        //draw shape
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitDot(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }
}
