package com.company;

import java.io.*;
import java.util.ArrayList;

public abstract class StringsOfFile implements FileSystem {

    //FixME мусор в CURRENT.txt или poleznosti.txt (эти файлы лучше хранить в яндекс диске/отдельном гитхабе или типа того.
    //int i = 0;

/*
    int i; //поле класса для get чего-то

    public int getI() { //это метод для возврата i
        return this.i;
    }

    public StringsOfFile(int i) {
        this.i = i;
    }
*/

    //@Override
    public ArrayList readLines(ArrayList jj, String path, String name, int nuberOfStartStrings, int nuberOfEndStrings, int i) {
/*
        this.i=62; //
        int bb = this.i;

*/
        ArrayList<String> nStrings = null; // приходится иннициализировать объект типа ArrayList отдельно, т.к. без иннициализации не срабатывает return
        nStrings = new ArrayList<>(); // создаем ArrayList, для накопления в элементах прочитанных строк

        System.out.println(jj);
        String line = null;
        System.out.println(nStrings);
        nStrings = jj;
        System.out.println(nStrings);
        try (LineNumberReader br = new LineNumberReader(new FileReader(path + name))) {
            while ((line = br.readLine()) != null) { // считываем строки из br соблюдая 2 условия: пока строка не null либо пока кол-во прочитанных строк < maxQuantityOfString
                if (br.getLineNumber() <= nuberOfEndStrings && br.getLineNumber() >= nuberOfStartStrings) {  //проверяем входит данная строка по номеру в заданный диапазон номеров строк
                    nStrings.add(line); //заполняем элементы списка ArrayList считанными строками
                    System.out.println(nStrings);
                    //  Reader Reader = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nStrings;  // возвращаем массив
    }
}
