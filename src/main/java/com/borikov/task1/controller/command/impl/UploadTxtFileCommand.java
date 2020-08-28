package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.PagePath;
import com.borikov.task1.controller.RequestParameter;
import com.borikov.task1.controller.command.Command;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadTxtFileCommand implements Command {
    private static final String UPLOAD_DIRECTORY = "C:\\uploads";
    private static final String END_TEXT_NAME = ".txt";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String page = PagePath.ERROR;
        Path path = Paths.get(UPLOAD_DIRECTORY);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        for (Part part : request.getParts()) {
            String fileName = part.getSubmittedFileName();
            if (fileName != null) {
                if (fileName.endsWith(END_TEXT_NAME)) {
                    part.write(UPLOAD_DIRECTORY + File.separator + fileName);
                    LOGGER.log(Level.INFO, "Upload successful. File: {}", fileName);
                    request.setAttribute(RequestParameter.UPLOAD_RESULT, "upload successfully");
                } else {
                    LOGGER.log(Level.ERROR, "Upload failed. File: {}", fileName);
                    request.setAttribute(RequestParameter.UPLOAD_RESULT, "upload failed");
                }
            }
            page = PagePath.UPLOAD_RESULT;
        }
        return page;
    }
}
