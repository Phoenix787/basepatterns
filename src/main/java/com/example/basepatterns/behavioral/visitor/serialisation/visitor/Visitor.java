package com.example.basepatterns.behavioral.visitor.serialisation.visitor;

import com.example.basepatterns.behavioral.visitor.serialisation.shapes.Circle;
import com.example.basepatterns.behavioral.visitor.serialisation.shapes.CompoundShape;
import com.example.basepatterns.behavioral.visitor.serialisation.shapes.Dot;
import com.example.basepatterns.behavioral.visitor.serialisation.shapes.Rectangle;

public interface Visitor {

    String visitCircle(Circle circle);

    String visitCompoundShape(CompoundShape compoundShape);

    String visitRectangle(Rectangle rectangle);

    String visitDot(Dot dot);

}
