package com.mikola.shape.director;

import com.mikola.shape.creator.SimpleBallFactory;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import com.mikola.shape.parser.BallParser;
import com.mikola.shape.reader.BallFileReader;
import com.mikola.shape.repository.impl.BallRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Director {
    private static final Logger LOGGER = LogManager.getLogger(Director.class);
    private final BallFileReader ballFileReader;
    private final BallParser ballParser;
    private final SimpleBallFactory ballFactory;

    public Director(BallFileReader ballFileReader, BallParser ballParser, SimpleBallFactory ballFactory) {
        this.ballFileReader = ballFileReader;
        this.ballParser = ballParser;
        this.ballFactory = ballFactory;
    }

    public BallRepository createRepositoryOfBalls(String path) throws BallException {
        BallRepository ballRepository = new BallRepository();
        List<String> ballDataLines = ballFileReader.read(path);
        LOGGER.info("Read data from file is succesful");
        // "this is not directors responsibility to know how to parse a line"
        // I don't know how to do it better.
        List<double[]> ballDataArrays = ballParser.parseLineToArray(ballDataLines);
        for (double[] array : ballDataArrays) {
            double oxCoordinate = array[0];
            double oyCoordinate = array[1];
            double ozCoordinate = array[2];
            Point center = new Point(
                    oxCoordinate,
                    oyCoordinate,
                    ozCoordinate
            );
            double radius = array[3];
            Ball ball = ballFactory.create(center, radius);
            LOGGER.info("created ball {}", ball);
            ballRepository.add(ball);
        }
        LOGGER.info("Repository consisting of balls created");
        return ballRepository;
    }

}
