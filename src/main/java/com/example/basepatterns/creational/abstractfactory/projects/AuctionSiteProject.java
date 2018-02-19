package com.example.basepatterns.creational.abstractfactory.projects;

import com.example.basepatterns.creational.abstractfactory.Developer;
import com.example.basepatterns.creational.abstractfactory.ProjectManager;
import com.example.basepatterns.creational.abstractfactory.ProjectTeamFactory;
import com.example.basepatterns.creational.abstractfactory.Tester;
import com.example.basepatterns.creational.abstractfactory.website.WebsiteTeamFactory;

public class AuctionSiteProject {
    public static void main(String[] args) {
        ProjectTeamFactory ptf = new WebsiteTeamFactory();

        Developer developer = ptf.createDeveloper();
   //     Developer developer1 = ptf.createDeveloper();
        Tester tester = ptf.createTester();
        ProjectManager projectManager = ptf.createProjectManager();

        System.out.println("Creating website...");
        developer.writeCode();
    //    developer1.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
