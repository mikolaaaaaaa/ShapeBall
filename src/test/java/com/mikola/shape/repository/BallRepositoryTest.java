package com.mikola.shape.repository;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import com.mikola.shape.repository.impl.BallRepository;
import com.mikola.shape.repository.impl.IdSpecification;
import com.mikola.shape.repository.impl.SurfaceAreaSpecification;
import com.mikola.shape.repository.impl.VolumeSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallRepositoryTest {

    private Ball ball;
    private Map<Long,Ball> expectedMap;
    private Map<Long,Ball> actualMap;
    private BallRepository ballRepository;

    @BeforeEach
    public void setUp() {
    ball = new Ball(new Point(1,1,1),2);
    expectedMap = new HashMap<>();
    actualMap = new HashMap<>();
    ballRepository = new BallRepository();
    }

    @Test
    public void testAddShouldAddBall() {
        //given
        expectedMap.put(ball.getId(),ball);
        //when
        ballRepository.add(ball);
        actualMap = ballRepository.getStore();
        //then
        Assertions.assertEquals(actualMap,expectedMap);
    }
    @Test
    public void testRemoveShouldRemoveBall() {
        ballRepository.add(ball);
        ballRepository.remove(ball);
        expectedMap = ballRepository.getStore();
        Assertions.assertTrue(expectedMap.isEmpty());
    }
    @Test
    public void testUpdateShouldUpdateBall() {
        ballRepository.add(ball);
        ball.setCenter(new Point(2,2,2));
        ballRepository.update(ball);
        expectedMap.put(ball.getId(),ball);
        actualMap = ballRepository.getStore();
        Assertions.assertEquals(expectedMap,actualMap);
    }
    @Test
    public void testQueryShouldFilterBySpecifications() throws BallException {
        //given
        Ball firstTestBall = new Ball(new Point(2,2,2),4);
        Ball secondTestBall = new Ball(new Point(1,1,1),2);
        Specification idSpecification = new IdSpecification(0,firstTestBall.getId()); // 3 - count of created balls
        ballRepository.add(firstTestBall);
        ballRepository.add(secondTestBall);
        List<Ball> expected = List.of(firstTestBall);
        //when
        List<Ball> actual = ballRepository.query(idSpecification);
        //then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testVolumeSpecificationShouldFilterByVolume() throws BallException {
        Ball firstTestBall = new Ball(new Point(2,2,2),4);
        Ball secondTestBall = new Ball(new Point(1,1,1),2);
        Specification volumeSpecification = new VolumeSpecification(0,8);
        ballRepository.add(firstTestBall);
        ballRepository.add(secondTestBall);
        List<Ball> expected = List.of(secondTestBall);
        List<Ball> actual = ballRepository.query(volumeSpecification);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testSurfaceAreaSpecificationShouldFilterBySurfaceAres() throws BallException {
        Ball firstTestBall = new Ball(new Point(2,2,2),4);
        Ball secondTestBall = new Ball(new Point(1,1,1),2);
        Specification surfaceAreaSpecification = new SurfaceAreaSpecification(0,52);
        ballRepository.add(firstTestBall);
        ballRepository.add(secondTestBall);
        List<Ball> expected = List.of(secondTestBall);
        List<Ball> actual = ballRepository.query(surfaceAreaSpecification);
        Assertions.assertEquals(expected,actual);
    }

}
