package com.example.basepatterns.structural.composite;

public class Project {
    public static void main(String[] args) {
        Team team = new Team(); //контейнер

        //компоненты-листья
        Developer firstJavaDeveloper = new JavaDeveloper();
        Developer secondJavaDeveloper = new JavaDeveloper();
        Developer cppJavaDeveloper = new CppDeveloper();

        team.addDeveloper(firstJavaDeveloper);
        team.addDeveloper(secondJavaDeveloper);
        team.addDeveloper(cppJavaDeveloper);

        team.createProject();
    }
}
