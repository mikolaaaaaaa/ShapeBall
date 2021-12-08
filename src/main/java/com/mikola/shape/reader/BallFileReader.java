package com.mikola.shape.reader;

import com.mikola.shape.exception.BallException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BallFileReader {
    private static final Logger logger = LogManager.getLogger(BallFileReader.class);

    public static List<String> readBallFromFile(String path) throws BallException {
        if (path == null || path.isEmpty()) {
            throw new BallException("Given path is null or empty");
        }
        Path dataFile = Path.of(path);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(dataFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.error("The file path is incorrect");
            e.printStackTrace();
        }
        logger.info("Reading from the file was successful");
        return lines;
    }
}
