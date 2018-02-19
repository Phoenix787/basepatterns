package com.example.basepatterns.creational.abstractfactory.projects;

import com.example.basepatterns.creational.abstractfactory.Developer;
import com.example.basepatterns.creational.abstractfactory.ProjectManager;
import com.example.basepatterns.creational.abstractfactory.ProjectTeamFactory;
import com.example.basepatterns.creational.abstractfactory.Tester;
import com.example.basepatterns.creational.abstractfactory.banking.BankingTeamFactory;

public class SuperBankSystem {

    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer developer = projectTeamFactory.createDeveloper();
        Tester tester = projectTeamFactory.createTester();
        ProjectManager projectManager = projectTeamFactory.createProjectManager();

        System.out.println("Creatin banking system...");

        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
