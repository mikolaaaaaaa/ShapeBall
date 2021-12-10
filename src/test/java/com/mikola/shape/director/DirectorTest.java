package com.mikola.shape.director;

import com.mikola.shape.creator.SimpleBallFactory;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import com.mikola.shape.parser.BallParser;
import com.mikola.shape.reader.BallFileReader;
import com.mikola.shape.repository.impl.BallRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class DirectorTest {

    private final String PATH = "src/test/resources";

    @Test
    public void testCreateBallRepositoryShouldReturnBallsRepository() throws BallException {
        //given
        String VALID_DATA = "1.1 2.2 3.3 4";
        Ball validBall = new Ball(new Point(1.1, 2.2, 3.3), 4);

        BallFileReader ballFileReader = Mockito.mock(BallFileReader.class);
        List<String> stringLines = List.of(VALID_DATA);
        Mockito.when(ballFileReader.readBallFromFile(PATH)).thenReturn(stringLines);

        BallParser ballParser = Mockito.mock(BallParser.class);
        List<double[]> doubleList = List.of(new double[]{1.1, 2.2, 3.3, 4});
        Mockito.when(ballParser.parseStringToArray(stringLines)).thenReturn(doubleList);

        SimpleBallFactory simpleBallFactory = Mockito.mock(SimpleBallFactory.class);
        Point center = new Point(doubleList.get(0)[0],
                doubleList.get(0)[1],
                doubleList.get(0)[2]);
        double radius = doubleList.get(0)[3];
        Mockito.when(simpleBallFactory.createBall(center, radius)).thenReturn(validBall);

        Director director = new Director(ballFileReader, ballParser, simpleBallFactory);
        BallRepository expectedRepository = new BallRepository();
        expectedRepository.add(validBall);
        //when
        BallRepository actualRepository = director.createRepositoryOfBalls(PATH);
        //then
        Assertions.assertEquals(actualRepository, expectedRepository);
    }

}
