package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class CountingOfStrings {

    // подсчитываем количество строк в исходном файле
    public int countingOfStrings(String path, String nameIshodFile) {
        int quantityOfStrings = 0;
        try (LineNumberReader stringsInText = new LineNumberReader(new FileReader(path + nameIshodFile))) {
            while (stringsInText.readLine() != null)
                quantityOfStrings = stringsInText.getLineNumber();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return quantityOfStrings;
    }
}
