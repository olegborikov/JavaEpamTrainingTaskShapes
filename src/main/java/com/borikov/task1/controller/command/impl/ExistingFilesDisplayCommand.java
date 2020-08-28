package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.PagePath;
import com.borikov.task1.controller.RequestParameter;
import com.borikov.task1.controller.command.Command;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExistingFilesDisplayCommand implements Command {
    private static final String UPLOAD_DIRECTORY = "C:\\uploads";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            Path path = Paths.get(UPLOAD_DIRECTORY);
            List<String> existingFiles = Files.list(path)
                    .map(path1 -> path1.getFileName().toString())
                    .collect(Collectors.toList());
            request.setAttribute(RequestParameter.EXISTING_FILES, existingFiles);
            page = PagePath.FILE_CHOOSE;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Error while working with file", e);
            page = PagePath.ERROR;
        }
        return page;
    }
}
