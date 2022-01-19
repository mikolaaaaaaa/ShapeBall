package com.mikola.shape.validator;

import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallValidatorTest {
    @Test
    public void testIsNumericShouldReturnTrue() throws BallException {
        //given
        String DATA = "1.1 1.1 1.1 1.1 1.1 1.1 1.1";
        //when
        boolean correctLine = BallValidator.chechInputLine(DATA);
        //then
        Assertions.assertTrue(correctLine);
    }

    @Test
    public void testIsNumericShouldReturnFalse() throws BallException {
        //given
        String DATA = "1.1a 1.1 1.1 1.1 1.1 1.1 1.1";
        //when
        boolean incorrectLine = BallValidator.chechInputLine(DATA);
        //then
        Assertions.assertFalse(incorrectLine);
    }

}
