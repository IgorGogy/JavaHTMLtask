package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
            while ((dicword = dic.readLine()) != null){
                dicHash.add(dicword);
            if (!dicword.matches("^[a-zA-Zа-яА-Я-]+$")) { //+$
                throw new InvalidTextException("Файл " + path + dicname + " по своему содержанию не является текстовым");}
            }

        } catch (FileNotFoundException e) {
            // Обработка исключения, если файл не найден
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            // Обработка исключения, если возникла ошибка при чтении файла
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (Exception e) {
            // Общая обработка исключений, если возникнет какое-либо другое исключение
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
      //  System.out.println(dicHash.size());
        return dicHash;
    }
}
