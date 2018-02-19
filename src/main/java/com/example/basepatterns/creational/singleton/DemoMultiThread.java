package com.example.basepatterns.creational.singleton;

public class DemoMultiThread {
    public static void main(String[] args) {
        System.out.println("RESULT:" + "\n");


        Thread first = new Thread(() -> {
            System.out.println(ProgramLogger.getInstance());
            ProgramLogger.getInstance().addLogInfo("FIRST");
            ProgramLogger.getInstance().showLogFile();
        });

        Thread second = new Thread(() -> {
            System.out.println(ProgramLogger.getInstance());
            ProgramLogger.getInstance().addLogInfo("SECOND");
            ProgramLogger.getInstance().showLogFile();
        });
        Thread third = new Thread(() -> {
            System.out.println(ProgramLogger.getInstance());
            ProgramLogger.getInstance().addLogInfo("THIRD");
            ProgramLogger.getInstance().showLogFile();
        });

        first.start();
        second.start();
        third.start();

    }
}
