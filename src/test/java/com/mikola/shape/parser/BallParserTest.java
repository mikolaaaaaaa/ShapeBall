package com.mikola.shape.parser;

import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class BallParserTest {
    @Test
    public void testParseStringToArray() throws BallException {
        List<double[]> expected = List.of(
                new double[] {1, 1, 1, 1, 1, 1, 1},
                new double[] {2, 2, 2, 2, 2, 2, 2}
        );
        List<String> stringList = List.of(
                "1.0 1.0 1.0 1.0 1.0 1.0 1.0",
                "1a 1.0 1.0 1.0 1.0 1.0 1.0",
                "1.0 1.0 1.0 1.0 1.0 1.0",
                "2.0 2.0 2.0 2.0 2.0 2.0 2.0"
        );
        List<double[]> actual = BallParser.parseStringToArray(stringList);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
        //  assertThat(actual,equalTo(expected));

    }
}
