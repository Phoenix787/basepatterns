package com.example.basepatterns.behavioral.visitor.project;

public interface Developer {
    void create(ProjectClass projectClass);
    void create(Database database);
    void create(Test test);
}
