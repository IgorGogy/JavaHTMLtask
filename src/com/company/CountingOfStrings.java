package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class CountingOfStrings {

    // подсчет количества строк в исходном файле
    public int countingOfStrings(String path, String dicname, int n_Strings) {
        int quantityOfStrings = 0;
        try (LineNumberReader stringsInText = new LineNumberReader(new FileReader(path + dicname))) {
            while (stringsInText.readLine() != null)
                quantityOfStrings = stringsInText.getLineNumber();

            if (quantityOfStrings>=n_Strings) { //+$
                throw new InvalidTextException("Количество строк в файле " + path + dicname + " более" + n_Strings);}



        } catch (
                IOException | InvalidTextException e) {
            e.printStackTrace();
        }
        return quantityOfStrings;

    }
}
