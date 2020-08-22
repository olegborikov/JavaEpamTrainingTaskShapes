package com.borikov.task1.controller.command;

public class CommandProvider {
    private static final CommandType DEFAULT_TYPE = CommandType.QUADRANGLE_DISPLAY_COMMAND;

    public Command defineCommand(String request) {
        CommandType currentType = DEFAULT_TYPE;
        if (request != null) {
            try {
                currentType = CommandType.valueOf(request.toUpperCase());
            } catch (IllegalArgumentException e) {
                // TODO: 22.08.2020 log + something
            }
        }
        Command currentCommand = currentType.getCommand();
        return currentCommand;
    }
}
