package com.borikov.task1.controller.command;

import com.borikov.task1.controller.command.impl.QuadrangleDisplayCommand;

public enum CommandType {
    QUADRANGLE_DISPLAY_COMMAND(new QuadrangleDisplayCommand());
    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
