package com.example.basepatterns.behavioral.chain.logging.var2;

public class ChainApp01 {
    public static void main(String[] args) {
        Logger logger = new SMSLogger(Level.ERROR);
        Logger fileLogger = new FileLogger(Level.DEBUG);
        Logger emailLogger = new EmailLogger(Level.INFO);

        logger.linkWith(fileLogger).linkWith(emailLogger);

        logger.writeMessage("Всё хорошо", Level.INFO);
        logger.writeMessage("Отладка", Level.DEBUG);
        logger.writeMessage("Всё сломалось шеф", Level.ERROR);


    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger{
    int priority;
    Logger next;

    public Logger(int priority){
        this.priority = priority;
    }

    public Logger linkWith(Logger next) {
        this.next = next;
        return next;
    }
//    public void setNext(Logger next) {
//        this.next = next;
//    }
    void  writeMessage(String message, int level){
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    };

    abstract void write(String message);
}

class SMSLogger extends Logger {
    public SMSLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("СМС: " + message);
    }
}

class FileLogger extends Logger {

    public FileLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("Записываем в файл: " + message);
    }
}

class EmailLogger extends Logger {

    public EmailLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("Email: " + message);
    }
}