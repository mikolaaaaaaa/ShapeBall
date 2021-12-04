package com.mikola.shape.parser;

import com.mikola.shape.exception.BallException;
import com.mikola.shape.validator.BallValidator;

import java.util.ArrayList;
import java.util.List;

public class BallParser {
    public static List<double[]> parseStringToArray(List<String> stringList) throws BallException {
       List<double[]> doubleList = new ArrayList<>();
       for(String i : stringList) {
           if (!BallValidator.chechInputLine(i)) {
               continue;
           }
           List<String> splitStringList = List.of(i.split(" "));
           double[] doubleArray = new double[splitStringList.size()];
           for(int j = 0; j < splitStringList.size(); j++) {
               doubleArray[j] = Double.parseDouble(splitStringList.get(j));
           }
           doubleList.add(doubleArray);
       }
       return doubleList;
    }
}
