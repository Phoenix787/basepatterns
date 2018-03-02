package com.example.basepatterns.behavioral.visitor.serialisation.shapes;

import com.example.basepatterns.behavioral.visitor.serialisation.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);

}
