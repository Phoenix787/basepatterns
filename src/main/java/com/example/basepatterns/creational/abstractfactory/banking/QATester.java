package com.example.basepatterns.creational.abstractfactory.banking;

import com.example.basepatterns.creational.abstractfactory.Tester;

public class QATester implements Tester {
    @Override
    public void testCode() {
        System.out.println("QA tester tests banking code...");
    }
}
