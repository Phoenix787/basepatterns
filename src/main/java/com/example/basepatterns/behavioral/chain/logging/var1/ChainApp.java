package com.example.basepatterns.behavioral.chain.logging.var1;

/**
 * мы видим что у нас повторяется код в реализациях интерфейса Logger,
 * поэтому его стоит сделать абстрактным классом см. ChainApp01
 */
public class ChainApp {
    public static void main(String[] args) {
        SMSLogger smsLogger0 = new SMSLogger(Level.ERROR);
        FileLogger fileLogger = new FileLogger(Level.DEBUG);
        EmailLogger emailLogger = new EmailLogger(Level.INFO);
        smsLogger0.setNext(fileLogger);
        fileLogger.setNext(emailLogger);

        smsLogger0.writeMessage("Всё хорошо", Level.INFO);
        smsLogger0.writeMessage("Отладка", Level.DEBUG);
        smsLogger0.writeMessage("Всё сломалось шеф", Level.ERROR);


    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

interface Logger{
    void writeMessage(String message, int level);
}

class SMSLogger implements Logger {
    int priority;
    Logger next;

    public SMSLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("СМС: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class FileLogger implements Logger{
    int priority;
    Logger next;

    public FileLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Записываем в файл: " + message);
        }
        if (next != null){
            next.writeMessage(message, level);
        }
    }
}


class EmailLogger implements Logger{
    int priority;
    Logger next;

    public EmailLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Email: " + message);
        }
        if (next != null){
            next.writeMessage(message, level);
        }
    }
}