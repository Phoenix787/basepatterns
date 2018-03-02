package com.example.basepatterns.behavioral.visitor.serialisation.shapes;

import com.example.basepatterns.behavioral.visitor.serialisation.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape {
    public int id;
    public List<Shape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundShape(this);
    }

    public void add(Shape child) {
        children.add(child);
    }

    public int getId() {
        return id;
    }
}
