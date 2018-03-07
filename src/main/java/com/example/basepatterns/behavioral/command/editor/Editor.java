package com.example.basepatterns.behavioral.command.editor;

import com.example.basepatterns.behavioral.command.editor.commands.Command;
import com.example.basepatterns.behavioral.command.editor.commands.CopyCommand;
import com.example.basepatterns.behavioral.command.editor.commands.CutCommand;
import com.example.basepatterns.behavioral.command.editor.commands.PasteCommand;

import javax.swing.*;
import java.awt.*;

public class Editor {
    public JTextArea textField;
    public String clipboard;
    public CommandHistory history = new CommandHistory();

    public void init(){
        JFrame frame = new JFrame("Text editor");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");

        Editor editor = this;

        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(editor)));

        ctrlX.addActionListener(e -> executeCommand(new CutCommand(editor)));

        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(editor)));

        ctrlZ.addActionListener(e->undo());

        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);
        frame.setSize(450, 200);
        frame.setVisible(true);
    }

    private void undo() {
        if (history.isEmpty()) {
            return;
        }
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

}
