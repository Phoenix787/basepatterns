package com.example.basepatterns.behavioral.command.commandApp;

public class DeleteCommand implements Command {
    private Database database;

    public DeleteCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.delete();
    }
}
