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
    private static final Logger logger = LogManager.getLogger(Director.class);
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
        List<String> stringList = ballFileReader.readBallFromFile(path);
        logger.info("Read data from file is succesful");
        List<double[]> doubleList = ballParser.parseStringToArray(stringList);
        for (double[] i : doubleList) {
            Point center = new Point(i[0], i[1], i[2]);
            double radius = i[3];
            Ball ball = ballFactory.createBall(center, radius);
            logger.info("created ball {}", ball);
            ballRepository.add(ball);
        }
        logger.info("Repository consisting of balls created");
        return ballRepository;
    }

}
