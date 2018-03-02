package com.example.basepatterns.behavioral.chain.app01;

public class BugTracker {
    public static void main(String[] args) {
        Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SMSNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("Everything is Ok", Priority.ROUTINE);
        System.out.println("\n------------------------------------------------------\n");
        reportNotifier.notifyManager("Someth. wrong", Priority.IMPORTANT);
        System.out.println("\n------------------------------------------------------\n");
        reportNotifier.notifyManager("Houaton, we've had a problem", Priority.ASAP);
    }
}
