package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class DicRead {

    public HashSet dicWord(String path, String dicname, int n) {
        ArrayList<String> dicArray = null;
        HashSet<String> dicHash = null;
        try (BufferedReader dic = new BufferedReader(new FileReader(path + dicname))) {
            String dicword;
            dicHash = new HashSet<>();
            while ((dicword = dic.readLine()) != null)
                dicHash.add(dicword);
            boolean containsBanana = dicHash.contains("banana");
            boolean containsBanana2 = dicHash.contains("солнце");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла словаря: " + e.getMessage());
        }
        return dicHash; //.get(n);
    }
}
