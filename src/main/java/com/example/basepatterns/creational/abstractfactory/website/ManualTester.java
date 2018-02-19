package com.example.basepatterns.creational.abstractfactory.website;

import com.example.basepatterns.creational.abstractfactory.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Manual tester tests web code...");
    }
}
