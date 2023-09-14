package com.company;


import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "\"\\"; // записываем в path адрес строки в которую скопировали проект с кодом. "C:\\SOURCES\\JavaHTMLtask\\";
        String nameIshodFile = "ishod.txt";
        String nameHTMLFile = "prihod"; 
        String dicName = "dic.txt";
        String symbols = "symbols.txt";
        String fileLetters = "letters.txt";
        int N = 10; // количество строк в куске прочиаемого текста в итоге в файле html
        int i = 0;  // суммарное количество прочитанных строк в ходе выполнения кода
        int j = 0; //номер слова в словаре dic.txt
        int quantityOfDicStrings = 100000; // максимальное количество строк в словаре
        int numberOfStartStrings = 0;
        int numberOfEndStrings = numberOfStartStrings + N;
        ArrayList leftoverOftext = new ArrayList<>();

        // ЗАПУСКАЕМ ПРОВЕРКУ РАЗМЕРА ФАЙЛА

        CountOfFileSize sizeOfFile = new CountOfFileSize();
        Boolean sizeIshod = sizeOfFile.isFileSizeLess2Mb(path, nameIshodFile);
        Boolean sizeDic = sizeOfFile.isFileSizeLess2Mb(path, dicName);

            // подсчитываем количество строк в исходном файле
            CountingOfStrings quantityOfStrings = new CountingOfStrings();
            int iStrings = quantityOfStrings.countingOfStrings(path, nameIshodFile);

        //Усовие блокирует выполнение программы если размер исходного или словаря файла превышает 2Мб либо кол-строк словаря > 100к
        if (sizeIshod && sizeDic && iStrings<quantityOfDicStrings) {

            while (i < iStrings) {

                // Чтение части текста величиной в n(N) строк.

                ReadPartOfText partOfText = new ReadPartOfText();
                ArrayList<String> n_strings = partOfText.readLines(leftoverOftext, path, nameIshodFile, numberOfStartStrings, numberOfEndStrings, i);
                i = i + n_strings.size(); //счетчик строк по всему файлу
                numberOfStartStrings = numberOfEndStrings + 1;
                numberOfEndStrings = numberOfEndStrings + N;

                // Чтение файла словаря

                DicRead dicWrd = new DicRead();
                HashSet dicWords = dicWrd.dicWord(path, dicName, j);

                // Символы и знаки препенания ASCII

                DicRead ASCIIonlySymbols = new DicRead();
                HashSet symbolsASCIILoUToFl = ASCIIonlySymbols.dicWord(path, symbols, j);

                // Буквы руского английского алфавита

                DicRead RusLetters = new DicRead();
                HashSet letters = RusLetters.dicWord(path, fileLetters, j);

                //Изменение части текста жирным и наклонным
                System.out.println(n_strings);
                MakingChangesInPartOfText partOfTextForChange = new MakingChangesInPartOfText();
                ArrayList<String> partWasChanged = partOfTextForChange.makingWordsBoldAndItalic(n_strings, dicWords, symbolsASCIILoUToFl, letters);

                // Передача обработанной части текста для записи в файл
                System.out.println(partWasChanged);
                WriteInHTMLfile writerHTML = new WriteInHTMLfile();
                leftoverOftext = writerHTML.startHTMLTeg(partWasChanged, nameHTMLFile, path, i, N);
                System.out.println(leftoverOftext);
                if (!leftoverOftext.isEmpty()) {
                    iStrings++;
                }
            }
        }
        System.out.println("Превышен размер файла");
    }
}
