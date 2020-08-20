package com.borikov.task1.socket;

import com.borikov.task1.creator.QuadrangleCreator;
import com.borikov.task1.entity.Quadrangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleSocket {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String FILE_NAME = "input/data.txt";

    public static void main(String[] args) {
        QuadrangleCreator quadrangleCreator = new QuadrangleCreator();
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            LOGGER.log(Level.INFO, "Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                LOGGER.log(Level.INFO, "Client connected!");
                try (PrintWriter output = new PrintWriter(socket.getOutputStream())) {
                    List<Quadrangle> quadrangles =
                            quadrangleCreator.createQuadranglesFromFile(FILE_NAME);
                    String answer = quadrangles.stream()
                            .map(Quadrangle::toString)
                            .collect(Collectors.joining("<br>"));
                    output.println("HTTP/1.1 200 OK");
                    output.println("Content-Type: text/html; charset=utf-8");
                    output.println("");
                    output.println(answer);
                    output.flush();
                    LOGGER.log(Level.INFO, "Client disconnected!");
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Error while opening server socket", e);
        }
    }
}
