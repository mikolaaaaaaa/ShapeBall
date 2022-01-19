package com.mikola.shape.validator;

import com.mikola.shape.exception.BallException;

public class BallValidator {
    private static final String TEMPLATE_REGEX = "([-0-9]+\\.[0-9]+\s+){7}";

    public static boolean chechInputLine(String s) throws BallException {
        if (s == null) {
            throw new BallException("Given string is null");
        }
        s += " ";
        return s.matches(TEMPLATE_REGEX);
    }

}
