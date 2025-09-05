package com.santos.drawfx.command;

public interface Command {
    void execute();
    void undo();
    void redo();
}
