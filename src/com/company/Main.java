package com.company;
//import Classes.File;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
   public static void main(String[] args) {
        String path = "C:\\Users\\СУПЕР\\Documents\\Idea_task\\TskHTML\\";
        String nameIshodFile = "ishod.txt"; //"IMG_4860.MOV.mov"   "ishod.txt"
        String nameHTMLFile = "prihod"; //"IMG_4860.MOV.mov"   "ishod.txt"

        String dicName = "dic.txt";
        String symbols = "symbols.txt";
        String fileLetters = "letters.txt";

        int N = 10;
        int i = 0;
        int j = 0; //номер слова в словаре dic.txt
        int numberOfStartStrings = 0;
        int numberOfEndStrings = numberOfStartStrings + N;

        // ЗАПУСКАЕМ ПРОВЕРКУ РАЗМЕРА ФАЙЛА
            CountOfFileSize sizeOfFile = new CountOfFileSize();
            Boolean sizeYorN = sizeOfFile.isFileSizeLess2Mb(path, nameIshodFile);

        //Усовие блокирует выполнение программы если размер исходного файла превышает 2Мб
     if (sizeYorN) {

        // подсчитываем количество строк в исходном файле

            CountingOfStrings quantityOfStrings = new CountingOfStrings();
            int iStrings = quantityOfStrings.countingOfStrings(path, nameIshodFile);
        while (i<iStrings) {
        // Чтение части текста величиной в n(N) строк.

            ReadPartOfText partOfText = new ReadPartOfText();
            ArrayList<String> n_strings = partOfText.readLines(path, nameIshodFile, numberOfStartStrings, numberOfEndStrings, i);
        //    System.out.println(n_strings);
        //    System.out.println(n_strings.size());
            i=i+n_strings.size(); //счетчик строк по всему файлу
            numberOfStartStrings=numberOfEndStrings+1;
            numberOfEndStrings=numberOfEndStrings+N;
        // Чтение файла словаря

            DicRead dicWrd = new DicRead();
            HashSet dicWords = dicWrd.dicWord(path, dicName, j);

        // Символы и знаки препенания ASCII

            DicRead ASCIIonlySymbols = new DicRead();
            HashSet symbolsASCIILoUToFl = ASCIIonlySymbols.dicWord(path, symbols, j);
          //  System.out.println(symbolsASCIILoUToFl);

        // Буквы руского английского алфавита

            DicRead RusLetters = new DicRead();
            HashSet letters = RusLetters.dicWord(path, fileLetters, j);
          //  System.out.println(russLetters);






        //Изменение части текста жирным и наклонным
            System.out.println(n_strings);
            MakingChangesInPartOfText partOfTextForChange = new MakingChangesInPartOfText();
            ArrayList<String> partWasChanged = partOfTextForChange.makingWordsBoldAndItalic(n_strings, dicWords, symbolsASCIILoUToFl, letters);


        // Передача обработанной части текста для записи в файл
            System.out.println(partWasChanged);
            WriteInHTMLfile writerHTML = new WriteInHTMLfile();
            Integer jj = writerHTML.startHTMLTeg(partWasChanged, nameHTMLFile, path, i);



         }

     }
        System.out.println("Превышен размер файла");

        // write your code here
   }
}
