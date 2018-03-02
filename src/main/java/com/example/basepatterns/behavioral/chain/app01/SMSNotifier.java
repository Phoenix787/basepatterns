package com.example.basepatterns.behavioral.chain.app01;

public class SMSNotifier extends Notifier {
    public SMSNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("SMS sendint to manager: " + message);
    }
}
