package ru.mirea.task6;

import java.util.ArrayList;
import java.util.List;

public interface Command {
    void execute(StringBuilder stringBuilder);
}

class AppendCommand implements Command {
    private final String textToAppend;

    public AppendCommand(String textToAppend) {
        this.textToAppend = textToAppend;
    }

    @Override
    public void execute(StringBuilder stringBuilder) {
        stringBuilder.append(textToAppend);
    }
}

class DeleteCommand implements Command {
    private final int start;
    private final int end;
    private final String deletedText;

    public DeleteCommand(int start, int end, String deletedText) {
        this.start = start;
        this.end = end;
        this.deletedText = deletedText;
    }

    @Override
    public void execute(StringBuilder stringBuilder) {
        stringBuilder.delete(start, end);
    }
}

class UndoCommand implements Command {
    private final Command previousCommand;

    public UndoCommand(Command previousCommand) {
        this.previousCommand = previousCommand;
    }

    @Override
    public void execute(StringBuilder stringBuilder) {
        previousCommand.execute(stringBuilder);
    }
}

class CustomStringBuilder {
    private StringBuilder stringBuilder;
    private List<Command> commandHistory;

    public CustomStringBuilder() {
        stringBuilder = new StringBuilder();
        commandHistory = new ArrayList<>();
    }

    public void append(String text) {
        AppendCommand appendCommand = new AppendCommand(text);
        appendCommand.execute(stringBuilder);
        commandHistory.add(appendCommand);
    }

    public void delete(int start, int end) {
        String deletedText = stringBuilder.substring(start, end);
        DeleteCommand deleteCommand = new DeleteCommand(start, end, deletedText);
        deleteCommand.execute(stringBuilder);
        commandHistory.add(deleteCommand);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            int lastIndex = commandHistory.size() - 1;
            Command lastCommand = commandHistory.get(lastIndex);
            commandHistory.remove(lastIndex);

            if (lastCommand instanceof UndoCommand) {
                lastCommand.execute(stringBuilder);
            }
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();

        customStringBuilder.append("Hello, ");
        customStringBuilder.append("world!");

        System.out.println(customStringBuilder.toString());

        customStringBuilder.delete(5, 12);
        System.out.println(customStringBuilder.toString());

        customStringBuilder.undo();
        System.out.println(customStringBuilder.toString());
    }
}
