package com.example.basepatterns.behavioral.command.editor.commands;

import com.example.basepatterns.behavioral.command.editor.Editor;

public abstract class Command {
    public Editor editor;
    protected String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public void undo(){
        editor.textField.setText(backup);
    }

    public void backup(){
        backup = editor.textField.getText();
    }

    public abstract boolean execute();
}
