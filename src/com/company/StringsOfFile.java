package com.company;

import java.io.*;
import java.util.ArrayList;

public abstract class StringsOfFile implements FileSystem {

    //Done!//FixME мусор в CURRENT.txt или poleznosti.txt (эти файлы лучше хранить в яндекс диске/отдельном гитхабе или типа того.
    public ArrayList readLines(ArrayList jj, String path, String name, int nuberOfStartStrings, int nuberOfEndStrings, int i) {
        ArrayList<String> nStrings = null; // иннициализация объект типа ArrayList отдельно, т.к. без иннициализации не срабатывает return
        nStrings = new ArrayList<>(); // создание ArrayList, для накопления в элементах прочитанных строк
        String line = null;
        nStrings = jj;
        try (LineNumberReader br = new LineNumberReader(new FileReader(path + name))) {
            while ((line = br.readLine()) != null) { // считываем строки из br соблюдая 2 условия: пока строка не null либо пока кол-во прочитанных строк < maxQuantityOfString
                if (br.getLineNumber() <= nuberOfEndStrings && br.getLineNumber() >= nuberOfStartStrings) {  //проверяем входит данная строка по номеру в заданный диапазон номеров строк
                    nStrings.add(line); //заполняем элементы списка ArrayList считанными строками
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nStrings;  // возвращаем массив
    }
}
