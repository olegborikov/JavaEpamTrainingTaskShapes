package com.borikov.task1.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(urlPatterns = {"/upload/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "C:\\Users\\Oleshka\\Desktop" +
            "\\JavaEpamTrainingTaskShapes\\src\\main\\webapp\\uploads";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Path path = Paths.get(UPLOAD_DIRECTORY);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        request.getParts().forEach(part -> {
            try {
                String fileName = part.getSubmittedFileName();
                part.write(UPLOAD_DIRECTORY + File.separator + fileName);
                request.setAttribute(RequestParameter.UPLOAD_RESULT, "upload successfully");
            } catch (IOException e) {
                LOGGER.log(Level.ERROR, "File upload failed", e);
                request.setAttribute(RequestParameter.UPLOAD_RESULT, "upload failed");
            }
        });
        request.getRequestDispatcher(PagePath.UPLOAD_RESULT).forward(request, response);
    }
}
