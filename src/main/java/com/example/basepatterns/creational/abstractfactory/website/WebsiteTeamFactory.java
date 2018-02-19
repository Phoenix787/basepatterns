package com.example.basepatterns.creational.abstractfactory.website;

import com.example.basepatterns.creational.abstractfactory.Developer;
import com.example.basepatterns.creational.abstractfactory.ProjectManager;
import com.example.basepatterns.creational.abstractfactory.ProjectTeamFactory;
import com.example.basepatterns.creational.abstractfactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer createDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester createTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager createProjectManager() {
        return new WebsitePM();
    }
}
