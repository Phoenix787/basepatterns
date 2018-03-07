package com.example.basepatterns.behavioral.command.editor.commands;

import com.example.basepatterns.behavioral.command.editor.Editor;
import com.example.basepatterns.behavioral.command.editor.commands.Command;

public class PasteCommand extends Command {
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard.isEmpty()) return false;
        backup();
        editor.textField.append(editor.clipboard);
        return true;
    }
}
