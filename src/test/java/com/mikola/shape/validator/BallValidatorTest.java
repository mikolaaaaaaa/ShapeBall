package com.mikola.shape.validator;

import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallValidatorTest {
    @Test
    public void testIsNumericGood() throws BallException {
        String s = "1.1 1.1 1.1 1.1 1.1 1.1 1.1";
        Assertions.assertTrue(BallValidator.chechInputLine(s));
    }

    @Test
    public void testIsNumericBad() throws BallException {
        String s = "1.1a 1.1 1.1 1.1 1.1 1.1 1.1";
        Assertions.assertFalse(BallValidator.chechInputLine(s));
    }
}
