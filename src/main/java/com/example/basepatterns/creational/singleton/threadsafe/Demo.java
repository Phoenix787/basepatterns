package com.example.basepatterns.creational.singleton.threadsafe;

/**
 * здесь показан пример, когда создаются два синглтона в двух потоках, так как каждый потоки не синхронизированы,
 * т. е. в какой-то момент, они одновременно получают информацию о том что instance == null, одновременно заходят в
 * конструктор и создают свой собственный экземпляр Singleton
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");

        Thread foo = new Thread(()->{
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        });

        Thread bar = new Thread(()->{
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        });

        foo.start();
        bar.start();
    }
}
