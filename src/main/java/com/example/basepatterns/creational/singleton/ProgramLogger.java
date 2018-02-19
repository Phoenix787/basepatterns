package com.example.basepatterns.creational.singleton;

import static java.lang.Thread.sleep;

public class ProgramLogger {
    private static volatile ProgramLogger instance;
    private static String logFile = "This is log file\n\n";

    private ProgramLogger() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public static ProgramLogger getInstance(){
        if (instance == null){
            synchronized (ProgramLogger.class){
                if (instance == null) {
                    instance = new ProgramLogger();
                }
            }
        }
        return instance;
    }

    public void addLogInfo(String logInfo) {
        logFile += logInfo + "\n";
    }

    public void showLogFile(){
        System.out.println(logFile);
    }
}
