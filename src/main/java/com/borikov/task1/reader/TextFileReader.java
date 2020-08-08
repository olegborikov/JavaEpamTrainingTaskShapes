package com.borikov.task1.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextFileReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<String> readText(String fileName) {
        Path path = Paths.get(fileName);
        try {
            List<String> paragraphText = Files.readAllLines(path);
            return paragraphText;
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "Incorrect file", e);
            throw new RuntimeException(e);
        }
    }
}
