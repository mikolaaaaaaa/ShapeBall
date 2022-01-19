package com.mikola.shape.parser;

import com.mikola.shape.exception.BallException;
import com.mikola.shape.validator.BallValidator;

import java.util.ArrayList;
import java.util.List;

public class BallParser {
    public List<double[]> parseLineToArray(List<String> stringList) throws BallException {
        List<double[]> doubleList = new ArrayList<>();
        for (String string : stringList) {
            if (BallValidator.chechInputLine(string)) {
                List<String> splitStringList = List.of(string.split(" "));
                doubleList.add(parseSplitStringListToArray(splitStringList));
            }
        }
        return doubleList;
    }

    private double[] parseSplitStringListToArray(List<String> splitStringList) {
        double[] doubleArray = new double[splitStringList.size()];
        for (int j = 0; j < splitStringList.size(); j++) {
            doubleArray[j] = Double.parseDouble(splitStringList.get(j));
        }
        return doubleArray;
    }
}
