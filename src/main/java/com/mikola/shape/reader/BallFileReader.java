package com.mikola.shape.reader;

import com.mikola.shape.exception.BallException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BallFileReader {
    private static final Logger LOGGER = LogManager.getLogger(BallFileReader.class);

    public List<String> read(String path) {
        List<String> stringLines = new ArrayList<>();
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(path))) {
            String temp;
            while ((temp = reader.readLine()) != null) {
                stringLines.add(temp);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("The file path is incorrect");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.info("Reading from the file was successful");
        return stringLines;
    }
}
