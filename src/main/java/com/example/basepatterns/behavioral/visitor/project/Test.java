package com.example.basepatterns.behavioral.visitor.project;

public class Test implements ProjectElement {
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}
