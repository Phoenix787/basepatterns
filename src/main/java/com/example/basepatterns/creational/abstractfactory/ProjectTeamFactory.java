package com.example.basepatterns.creational.abstractfactory;



//сущность которая создает сразу всю команду разработчиков


public interface ProjectTeamFactory {
    Developer createDeveloper();
    Tester createTester();
    ProjectManager createProjectManager();
}
