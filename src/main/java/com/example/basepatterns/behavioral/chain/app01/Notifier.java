package com.example.basepatterns.behavioral.chain.app01;

public abstract class Notifier {
    private int priority;
    private Notifier nextNotifier; // с помощью этого уведомителя мы сможем передавать запрос куда-то дальше


    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifyManager(String message, int level) {
        if (level >= priority) {
            write(message);
        }
        if (nextNotifier != null) {
            nextNotifier.notifyManager(message, level);
        }
    }

    public abstract void write(String message);
}
