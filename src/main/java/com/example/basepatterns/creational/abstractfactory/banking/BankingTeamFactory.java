package com.example.basepatterns.creational.abstractfactory.banking;

import com.example.basepatterns.creational.abstractfactory.Developer;
import com.example.basepatterns.creational.abstractfactory.ProjectManager;
import com.example.basepatterns.creational.abstractfactory.ProjectTeamFactory;
import com.example.basepatterns.creational.abstractfactory.Tester;

//создаем сущность - фабрику, которая будет создавать команду для разработки банковского ПО

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester createTester() {
        return new QATester();
    }

    @Override
    public ProjectManager createProjectManager() {
        return new BankingPM();
    }
}
