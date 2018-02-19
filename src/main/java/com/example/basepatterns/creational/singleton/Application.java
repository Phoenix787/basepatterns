package com.example.basepatterns.creational.singleton;

public class Application {
    public static void main(String[] args) {
        ProgramLogger.getInstance().addLogInfo("First log info...");
        ProgramLogger.getInstance().addLogInfo("Second log info...");
        ProgramLogger.getInstance().addLogInfo("Third log info...");

        ProgramLogger.getInstance().showLogFile();
    }
}
