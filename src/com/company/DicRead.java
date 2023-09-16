package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Done!//Fixme WTF?? optimize import!
import java.util.HashSet;
//Done!//Fixme WTF?? optimize import!

public class DicRead {

    public HashSet dicWord(String path, String dicname) {
        HashSet<String> dicHash = null;
        try (BufferedReader dic = new BufferedReader(new FileReader(path + dicname))) {
            String dicword;
            dicHash = new HashSet<>();
            while ((dicword = dic.readLine()) != null)
                dicHash.add(dicword);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла словаря: " + e.getMessage());
        }
        return dicHash;
    }
}
