package com.example.basepatterns.structural.adapter;

public class AdapterJavaToDatabase extends JavaApplication implements Database {
    public void insert() {
        saveObject();
    }

    public void update() {
        updateObject();
    }

    public void select() {
        loadObject();
    }

    public void remove() {
        deleteObject();
    }
}
