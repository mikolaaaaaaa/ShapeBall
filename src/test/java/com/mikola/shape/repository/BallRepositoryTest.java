package com.mikola.shape.repository;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import com.mikola.shape.repository.impl.BallRepository;
import com.mikola.shape.repository.impl.IdSpecification;
import com.mikola.shape.repository.impl.SurfaceAreaSpecification;
import com.mikola.shape.repository.impl.VolumeSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallRepositoryTest {
    private static final Ball FIRST_BALL = new Ball(new Point(1, 1, 1), 2);
    private static final Ball SECOND_bALL = new Ball(new Point(2, 2, 2), 4);
    private static final Ball THIRD_BALL = new Ball(new Point(1, 1, 1), 2);

    @Test
    public void testAddShouldAddBall() {
        //given
        BallRepository ballRepository = new BallRepository();
        Map<Long,Ball> expectedMap = new HashMap<>();
        Map<Long,Ball> actualMap = new HashMap<>();
        expectedMap.put(FIRST_BALL.getId(), FIRST_BALL);
        //when
        ballRepository.add(FIRST_BALL);
        actualMap = ballRepository.getStore();
        //then
        Assertions.assertEquals(actualMap, expectedMap);
    }

    @Test
    public void testRemoveShouldRemoveBall() {
        BallRepository ballRepository = new BallRepository();
        ballRepository.add(FIRST_BALL);
        ballRepository.remove(FIRST_BALL);
        Map<Long,Ball> expectedMap;
        expectedMap = ballRepository.getStore();
        Assertions.assertTrue(expectedMap.isEmpty());
    }

    @Test
    public void testQueryShouldFilterBySpecifications() throws BallException {
        //given
        BallRepository ballRepository = new BallRepository();
        int from = 0;
        Specification idSpecification = new IdSpecification(from, SECOND_bALL.getId());
        ballRepository.add(THIRD_BALL);
        ballRepository.add(SECOND_bALL);
        List<Ball> expected = List.of(SECOND_bALL);
        //when
        List<Ball> actual = ballRepository.query(idSpecification);
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testVolumeSpecificationShouldFilterByVolume() throws BallException {
        BallRepository ballRepository = new BallRepository();
        double from = 0;
        double to = 8;
        Specification volumeSpecification = new VolumeSpecification(from, to);
        ballRepository.add(SECOND_bALL);
        ballRepository.add(THIRD_BALL);
        List<Ball> expected = List.of(THIRD_BALL);
        List<Ball> actual = ballRepository.query(volumeSpecification);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSurfaceAreaSpecificationShouldFilterBySurfaceAres() throws BallException {
        BallRepository ballRepository = new BallRepository();
        double from = 0;
        double to = 52;
        Specification surfaceAreaSpecification = new SurfaceAreaSpecification(from, to);
        ballRepository.add(SECOND_bALL);
        ballRepository.add(THIRD_BALL);
        List<Ball> expected = List.of(THIRD_BALL);
        List<Ball> actual = ballRepository.query(surfaceAreaSpecification);
        Assertions.assertEquals(expected, actual);
    }

}
