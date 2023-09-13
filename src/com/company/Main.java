package com.company;
//import Classes.File; //FixME WTF??

import java.util.ArrayList;
import java.util.HashSet;

//TODO 1 make classes like it was defined by you in phone conversation 12-9-23
//TODO *2 implement naming conventions in Java to make names better: more sence and meaningful https://clck.ru/35gYaw and
//TODO 3 same as 2 SO for method that returns list of objects https://clck.ru/35gYdM
//TODO *4 same as 3 method mainiming https://clck.ru/35gYkE
//TODO 5 same as 4 foк rest of all by Oracle Java convention https://clck.ru/35gdUW
//TODO *6 remove all as possible inline strings from code (to properties file, constants,... whatever to nowhere) Yes it's painfull
//TODO *7remove unnessesary empty lines 12+ in this  file
//TODO *8 optimize all imports in project

public class Main {
    public static void main(String[] args) {
        //FixME следующие 6 строк и далее до конца программы (see //TODO 6)
        String path = "C:\\Users\\СУПЕР\\Documents\\Idea_task\\TskHTML\\";
        String nameIshodFile = "ishod.txt"; //"IMG_4860.MOV.mov"   "ishod.txt"
        String nameHTMLFile = "prihod"; //"IMG_4860.MOV.mov"   "ishod.txt"

        String dicName = "dic.txt";
        String symbols = "symbols.txt";
        String fileLetters = "letters.txt";

        int N = 10;         //FixME N WTF??
        int i = 0;          //FixME i WTF??
        int j = 0; //номер слова в словаре dic.txt //FixME it's comment variable but what for to know number of word in vocabulary?
        int numberOfStartStrings = 0; //FixME WTF??
        int numberOfEndStrings = numberOfStartStrings + N; //FixME WTF??
        ArrayList jj = new ArrayList<>(); //FixME WTF?? jj=java juniors??

        //FixME * ВСЕ КОММЕРНТАРИИ не содержат повествовательных наклонений и прочего мусора
        //FixME https://clck.ru/35gbME +комментарии к статье
        //FixME например тут можно изменить на:
        //проверка размера файла.


        // ЗАПУСКАЕМ ПРОВЕРКУ РАЗМЕРА ФАЙЛА
        CountOfFileSize sizeOfFile = new CountOfFileSize();
        //FixME класс CountOfFileSize имеет странное имя в нем нет ничего. обект класса создается единожды
        // в одном единственном месте раlи одной тривиальной операции (класс мертв и бесполезен => избавиться от класса )
        // кроме одного метода (либо вынести в psvm, либо найти где ему место)
        Boolean sizeYorN = sizeOfFile.isFileSizeLess2Mb(path, nameIshodFile);

        //FixME то же самое тут и далее во всех комментариях
        //FixME цель информативность 100% сухость 146%.
        //FIXme ссылки на док, "мы", прочее 0%

        //Усовие блокирует выполнение программы если размер исходного файла превышает 2Мб //FixME опечатки + плохой комментарий
        if (sizeYorN) {

            // подсчитываем количество строк в исходном файле
//FixME WTF?? unnessesary empty line (see //TODO7) a plenty of them is there!
            CountingOfStrings quantityOfStrings = new CountingOfStrings();
            //FixME CountingOfStrings та же проблема что и с CountOfFileSize выше
            int iStrings = quantityOfStrings.countingOfStrings(path, nameIshodFile); //FixME iStrings WTF??
            while (i < iStrings) {
                // Чтение части текста величиной в n(N) строк.

                ReadPartOfText partOfText = new ReadPartOfText();

                System.out.println(jj); //FixME WTF??
                ////FixME выходит за границу экрана:
                //ArrayList<String> n_strings = partOfText.readLines(jj, path, nameIshodFile, numberOfStartStrings, numberOfEndStrings, i);
                //FixME лучше переписать так: в 2 стоки, видишь идея линию рисует желательно чтобы далеко за нее твои строкикода и комменты вот как жтот приходиться скролить вправо чтобы прочитать а это не удобно у тех у кого не макбук (там это удобно сделано) также обрати внимание все мои комменты не выходят за эту линию. кроме этой.
                ArrayList<String> n_strings = partOfText.readLines(jj, path,
                        nameIshodFile, numberOfStartStrings, numberOfEndStrings, i);

                i = i + n_strings.size(); //счетчик строк по всему файлу //FixME WTF?? bad practice, не надо так глобальные
                //FixME  счетчики это то отчего волосы шевеляться/ любой кто это смотрит начнет стараться закончить
                // просмотр от такого нужно избавляться// счетчики это то отчего волосы шевеляться/ любой кто это смотрит
                // начнет стараться закончить просмотр от такого нужно избавляться так лучше нагляднее и эффективнее
                numberOfStartStrings = numberOfEndStrings + 1;
                numberOfEndStrings = numberOfEndStrings + N;

                // Чтение файла словаря

                //FixME DicRead та же проблема что и с CountingOfStrings, CountOfFileSize выше
                DicRead dicWrd = new DicRead();
                HashSet dicWords = dicWrd.dicWord(path, dicName, j);

                // Символы и знаки препенания ASCII

                //Fixme WTF?? выглядит как очень нелогичная история:два раза читается одно и то же... вопросики..
                DicRead ASCIIonlySymbols = new DicRead();
                HashSet symbolsASCIILoUToFl = ASCIIonlySymbols.dicWord(path, symbols, j);
                //  System.out.println(symbolsASCIILoUToFl); //Fixme WTF??

                // Буквы руского английского алфавита

                DicRead RusLetters = new DicRead(); //Fixme WTF?? третий раз??? блин тут что-то странное происходит.. обьясни зачем три раза?
                HashSet letters = RusLetters.dicWord(path, fileLetters, j);
                //  System.out.println(russLetters); //FixME WTF??

                //Изменение части текста жирным и наклонным
                System.out.println(n_strings);//Fixme WTF??
                MakingChangesInPartOfText partOfTextForChange = new MakingChangesInPartOfText();
                ArrayList<String> partWasChanged = partOfTextForChange.makingWordsBoldAndItalic(n_strings, dicWords, symbolsASCIILoUToFl, letters);

                // Передача обработанной части текста для записи в файл
                System.out.println(partWasChanged);//Fixme WTF??
                WriteInHTMLfile writerHTML = new WriteInHTMLfile();
                jj = writerHTML.startHTMLTeg(partWasChanged, nameHTMLFile, path, i);
                System.out.println(jj);
                iStrings++;
            }
        }
        System.out.println("Превышен размер файла"); //FixME предусмотреть сообщение о выводе превышения 100 000 строк
        // write your code here //Fixme WTF??
    }
}
