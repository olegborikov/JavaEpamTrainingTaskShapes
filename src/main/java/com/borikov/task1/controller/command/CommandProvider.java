package com.borikov.task1.controller.command;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandProvider {
    private static final CommandType DEFAULT_TYPE = CommandType.DEFAULT_COMMAND;
    private static final Logger LOGGER = LogManager.getLogger();

    public Command defineCommand(String request) {
        CommandType currentType = DEFAULT_TYPE;
        if (request != null) {
            try {
                currentType = CommandType.valueOf(request.toUpperCase());
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.ERROR, "Incorrect command type: {}", request, e);
            }
        }
        Command currentCommand = currentType.getCommand();
        return currentCommand;
    }
}
