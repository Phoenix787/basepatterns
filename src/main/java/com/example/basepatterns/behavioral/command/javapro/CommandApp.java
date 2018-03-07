package com.example.basepatterns.behavioral.command.javapro;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new StartCommand(comp),
                new StopCommand(comp),
                new ResetCommand(comp));

        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}


interface Command{
    void execute();
}

//Receiver
class Comp{
    void start(){
        System.out.println("Start");
    }

    void stop(){
        System.out.println("Stop");
    }

    void reset(){
        System.out.println("Reset");
    }
}

//ConcreteCommand

//это как бы класс оболочка над классом Comp,
// но эта оболочка вызывает только одну команду класса Comp
class StartCommand implements Command{
    //чтобы это не повторялось во всех реализациях интерфейса Command, его можно сделать абстрактным классом
    Comp comp;
    public StartCommand(Comp comp) {
        this.comp = comp;
    }
    /**/

    @Override
    public void execute() {
        comp.start();
    }
}

class StopCommand implements Command{
    Comp comp;
    public StopCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.stop();
    }
}

class ResetCommand implements Command{
    Comp comp;
    public ResetCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.reset();
    }
}

//Invoker - класс который вызывает команды
// для чего он нужен? это тот класс, который умеет работать только с командами
// он не знает реализацию нашего компьютера, он про компьютер ничего не знает
// мы этому классу (USer) даем уже конкретные команды
// но так как он работает только с интерфейсами, он не знает какая команда как реализована
class User{
    private Command start;
    private Command stop;
    private Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void startComputer(){
        start.execute();
    }
    public void stopComputer(){
        stop.execute();
    }
    public void resetComputer(){
        reset.execute();
    }
}