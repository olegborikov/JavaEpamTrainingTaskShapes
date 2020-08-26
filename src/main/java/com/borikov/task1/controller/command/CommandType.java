package com.borikov.task1.controller.command;

import com.borikov.task1.controller.command.impl.DefaultCommand;
import com.borikov.task1.controller.command.impl.ExistingFilesDisplayCommand;
import com.borikov.task1.controller.command.impl.LoginCommand;
import com.borikov.task1.controller.command.impl.QuadrangleDisplayCommand;

public enum CommandType {
    QUADRANGLE_DISPLAY_COMMAND(new QuadrangleDisplayCommand()),
    EXISTING_FILES_DISPLAY_COMMAND(new ExistingFilesDisplayCommand()),
    DEFAULT_COMMAND(new DefaultCommand()),
    LOGIN_COMMAND(new LoginCommand());
    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
    }
