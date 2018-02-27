package com.example.basepatterns.structural.composite.example.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * здесь компановщик - контейнер, его методы делегируются компонентам-листьям
 */
public class CompositeShape extends BaseShape {
    protected List<Shape> shapes = new ArrayList<>();

    public CompositeShape(Shape... components) {
        super(0, 0, Color.BLACK);
        add(components);
    }

    public void add(Shape component){
        shapes.add(component);
    }

    public void add(Shape... components){
        shapes.addAll(Arrays.asList(components));
    }

    public void remove(Shape component){
        int i = shapes.indexOf(component);
        shapes.remove(i);
    }

    public void remove(Shape... components){
        shapes.removeAll(Arrays.asList(components));
    }

    public void clear(){
        shapes.clear();
    }

    @Override
    public int getX() {
        if (shapes.size() == 0) {
            return 0;
        }
        int x = shapes.get(0).getX();
        for (Shape shape : shapes) {
            if (shape.getX() < x){
                x = shape.getY();
            }
        }
        return x;
    }

    @Override
    public int getY() {
        if (shapes.size() == 0){
            return 0;
        }
        int y = shapes.get(0).getY();
        for (Shape shape : shapes) {
            if (shape.getY() < y) {
                y = shape.getY();
            }
        }
        return y;
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;
        int x = getX();
        for (Shape child : shapes) {
            int childsRelativeX = child.getX() - x;
            int childWidth = childsRelativeX + child.getWidth();
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        int y = getY();
        for (Shape child : shapes) {
            int childsRelativeY = child.getY() - y;
            int childHeight = childsRelativeY + child.getHeight();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void move(int x, int y) {
        for (Shape child : shapes) {
            child.move(x, y);
        }
    }

    @Override
    public Boolean isInsideBounds(int x, int y) {
        for (Shape child : shapes) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (Shape child : shapes) {
            child.unSelect();
        }
    }

    public Boolean selectChildAt(int x, int y) {
        for (Shape child : shapes) {
            if (child.isInsideBounds(x, y)) {
                child.select();
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }

        for (Shape child : shapes) {
            child.paint(graphics);
        }
    }
}
