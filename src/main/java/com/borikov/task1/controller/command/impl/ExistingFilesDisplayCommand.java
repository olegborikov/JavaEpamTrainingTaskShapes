package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExistingFilesDisplayCommand implements Command {
    private static final String UPLOAD_DIRECTORY = "C:\\Users\\Oleshka\\Desktop" +
            "\\JavaEpamTrainingTaskShapes\\src\\main\\webapp\\uploads";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Path path = Paths.get(UPLOAD_DIRECTORY);
        List<String> existingFiles = Files.list(path)
                .map(path1 -> path1.getFileName().toString())
                .collect(Collectors.toList());
        request.setAttribute("existingFiles", existingFiles);
        request.getRequestDispatcher("/jsp/file_choose.jsp").forward(request, response);
    }
}
