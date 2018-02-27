package com.example.basepatterns.structural.flyweight.trees.forest;

import com.example.basepatterns.structural.flyweight.trees.Tree;
import com.example.basepatterns.structural.flyweight.trees.TreeFactory;
import com.example.basepatterns.structural.flyweight.trees.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI-лес, который рисует деревья
 */
public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void paint(Graphics g){
        for (Tree tree : trees) {
            tree.draw(g);
        }
    }
}
