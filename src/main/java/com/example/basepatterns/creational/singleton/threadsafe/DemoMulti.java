package com.example.basepatterns.creational.singleton.threadsafe;

public class DemoMulti {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");

        Thread foo = new Thread(()->{
            SingletonThreadSafe singleton = SingletonThreadSafe.getInstance("FOO");
            System.out.println(singleton.value);
        });

        Thread bar = new Thread(()->{
            SingletonThreadSafe singleton = SingletonThreadSafe.getInstance("BAR");
            System.out.println(singleton.value);
        });

        foo.start();
        bar.start();
    }
}
