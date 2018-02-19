package com.example.basepatterns.creational.singleton.threadsafe;

public class SingletonThreadSafe {
    private static volatile SingletonThreadSafe instance;
    public static String value;

    public static SingletonThreadSafe getInstance(String value) {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class){
                if (instance == null) {
                    instance = new SingletonThreadSafe(value);
                }
            }
        }
        return instance;
    }

    private SingletonThreadSafe(String value) {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }
}
