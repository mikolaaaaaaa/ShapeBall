package com.mikola.shape.reader;

import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BallFileReaderTest {
    @Test
    public void testReadBallFromFileShouldReadStringLineFromFile() throws BallException {
        //given
        List<String> expected = List.of(
                "1 1 1 1 1 1 1",
                "1a 1 1 1 1 1",
                "2 2 2 2 2 2 2"
        );
        BallFileReader ballFileReader = new BallFileReader();
        String path = "src/test/resources/data.txt";
        //when
        List<String> actual = ballFileReader.read(path);
        //then
        Assertions.assertEquals(expected, actual);
    }
}
