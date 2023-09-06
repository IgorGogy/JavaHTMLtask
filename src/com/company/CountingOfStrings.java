package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class CountingOfStrings {

    // подсчитываем количество строк в исходном файле
    public int countingOfStrings(String path, String nameIshodFile) {
            int iStrings = 0;
        try (LineNumberReader kolStrok = new LineNumberReader(new FileReader(path + nameIshodFile))) {
            while (kolStrok.readLine() != null)
                iStrings = kolStrok.getLineNumber();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return iStrings;
    }



}
