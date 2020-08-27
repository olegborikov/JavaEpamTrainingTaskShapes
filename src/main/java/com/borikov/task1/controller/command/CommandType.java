package com.borikov.task1.controller.command;

import com.borikov.task1.controller.command.impl.*;

public enum CommandType {
    QUADRANGLE_DISPLAY_COMMAND(new QuadrangleDisplayCommand()),
    EXISTING_FILES_DISPLAY_COMMAND(new ExistingFilesDisplayCommand()),
    LOGIN_COMMAND(new LoginCommand()),
    LOGOUT_COMMAND(new LogoutCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
