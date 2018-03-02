package com.example.basepatterns.behavioral.visitor.serialisation.shapes;

import com.example.basepatterns.behavioral.visitor.serialisation.visitor.Visitor;

public class Rectangle implements Shape {
    public int x;
    public int y;
    public int width;
    public int height;
    public int id;

    public Rectangle() {
    }

    public Rectangle(int x, int y, int width, int height, int id) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
        return visitor.visitRectangle(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }
}
