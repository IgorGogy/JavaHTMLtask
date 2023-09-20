package com.company;//Fixme WTF?? - удалил

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;

//TODO 1 make classes like it was defined by you in phone conversation 12-9-23
//done!//TODO *2 implement naming conventions in Java to make names better: more sence and meaningful https://clck.ru/35gYaw and
//TODO 3 same as 2 SO for method that returns list of objects https://clck.ru/35gYdM
//done!//TODO *4 same as 3 method mainiming https://clck.ru/35gYkE
//TODO 5 same as 4 foк rest of all by Oracle Java convention https://clck.ru/35gdUW
//done!//TODO *6 remove all as possible inline strings from code (to properties file, constants,... whatever to nowhere) Yes it's painfull
//done!//TODO *7 remove unnessesary empty lines 12+ in this  file
//done!//TODO *8 optimize all imports in project

//TODO 1 создать классы, как они были определены вами в телефонном разговоре 12-9-23
//TODO *2 реализовать соглашения об именах в Java, чтобы имена были лучше: больше смысла и значимости https://clck.ru/35gYaw и
//TODO 3 то же, что 2 SO для метода, возвращающего список объектов https://clck.ru/35gYdM
//TODO *4 то же, что и 3 метода управления https://clck.ru/35gYkE
//TODO 5 то же, что и 4 для остального, в соответствии с соглашением Oracle Java https://clck.ru/35gdUW
//TODO *6 удалить все возможные встроенные строки из кода (в файл свойств, константы,... куда бы то ни было в никуда) Да, это болезненно
//TODO *7удаляем ненужные пустые строки 12+ в этом файле
//TODO *8 оптимизировать весь импорт в проекте

public class Main {
    public static void main(String[] args) {
        //Done!//FixME следующие 6 строк и далее до конца программы (see //TODO 6)
        String path = System.getProperty("user.dir") + "\\"; // Запись в path адрес строки в которую скопировали проект с кодом. "C:\\SOURCES\\JavaHTMLtask\\";
        Properties startData = new Properties();
        try {
            startData.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String nameIshodFile = startData.getProperty("nameIshodFile");
        String nameHTMLFile = startData.getProperty("nameHTMLFile");
        String dicName = startData.getProperty("dicName");
        int N = 10; // количество строк в куске прочитанного текста в итоге в файле html //FixME N WTF?? - добавил коммент
        int i = 0;  // суммарное количество прочитанных строк в ходе выполнения кода //FixME N WTF?? - добавил коммент
        //Done!//FixME it's comment variable but what for to know number of word in vocabulary?
        int quantityOfDicStrings = 100000; // максимальное количество строк в словаре
        int numberOfStartStrings = 0;
        int numberOfEndStrings = numberOfStartStrings + N;  //FixME WTF?????????????????????
        ArrayList leftoverOftext = new ArrayList<>();  //Done!//FixME WTF?? jj=java juniors?? - изменил

        //Done!//FixME * ВСЕ КОММЕРНТАРИИ не содержат повествовательных наклонений и прочего мусора  -  исправил
        //FixME https://clck.ru/35gbME +комментарии к статье
        //FixME например тут можно изменить на:
        //проверка размера файла.

        // ПРОВЕРКА РАЗМЕРА ФАЙЛА
        FileSize sizeOfFile = new FileSize();
        Boolean sizeIshod = sizeOfFile.isFileSizeLess2Mb(path, nameIshodFile);
        Boolean sizeDic = sizeOfFile.isFileSizeLess2Mb(path, dicName);

        //FixME класс CountOfFileSize имеет странное имя в нем нет ничего. обект класса создается единожды
        // в одном единственном месте раlи одной тривиальной операции (класс мертв и бесполезен => избавиться от класса )
        // кроме одного метода (либо вынести в psvm, либо найти где ему место)

        //FixME то же самое тут и далее во всех комментариях
        //FixME цель информативность 100% сухость 146%.
        //FIXme ссылки на док, "мы", прочее 0%

        //FixME опечатки + плохой комментарий - удалил

        // подсчет количества строк в исходном файле
        CountingOfStrings quantityOfStrings = new CountingOfStrings();
        int iStrings = quantityOfStrings.countingOfStrings(path, nameIshodFile, quantityOfDicStrings);

        // Чтение файла словаря

        //done//вроде корректно используется FixME DicRead та же проблема что и с CountingOfStrings, CountOfFileSize выше
        DicRead dicWrd = new DicRead();
        HashSet dicWords = dicWrd.dicWord(path, dicName);

        //блокировка выполнения программы если размер исходного или словаря файла превышает 2Мб либо кол-строк словаря > 100к
        if (!(dicWords == null) && sizeIshod && sizeDic && iStrings < quantityOfDicStrings) {
            while (i < iStrings) {
                // Чтение части текста величиной в n(N) строк.
                ReadPartOfText partOfText = new ReadPartOfText();

                ////FixME выходит за границу экрана:  ОК
                //Done!// FixME лучше переписать так: в 2 стоки, видишь идея линию рисует желательно чтобы далеко за нее твои строкикода и комменты вот как жтот приходиться скролить вправо чтобы прочитать а это не удобно у тех у кого не макбук (там это удобно сделано) также обрати внимание все мои комменты не выходят за эту линию. кроме этой.
                //???????? почему???? FixME  счетчики это то отчего волосы шевеляться/ любой кто это смотрит начнет стараться закончить
                ArrayList<String> n_strings = partOfText.readLines
                        (leftoverOftext, path, nameIshodFile, numberOfStartStrings, numberOfEndStrings, i);
                i = i + n_strings.size(); //счетчик строк по всему файлу
                numberOfStartStrings = numberOfEndStrings + 1;
                numberOfEndStrings = numberOfEndStrings + N;


                //вроде корректно используется  Fixme WTF?? выглядит как очень нелогичная история:два раза читается одно и то же... вопросики..
                //    DicRead ASCIIonlySymbols = new DicRead();
                //    HashSet symbolsASCIILoUToFl = ASCIIonlySymbols.dicWord(path, symbols);
                //Done!// Fixme WTF??

                //Done//    DicRead RusLetters = new DicRead(); //Fixme WTF?? третий раз??? блин тут что-то странное происходит.. обьясни зачем три раза?
                //   HashSet letters = RusLetters.dicWord(path, fileLetters);
                //Done!//удалил Fixme WTF??

                // Изменение части текста жирным и наклонным
                //Done!//удалил  Fixme WTF??
                ChangesInPartOfText partOfTextForChange = new ChangesInPartOfText();
                ArrayList<String> partWasChanged = partOfTextForChange.makingWordsBoldAndItalic(n_strings, dicWords);

                // Передача обработанной части текста для записи в файл
                //Done!//удалил  Fixme WTF??
                WriteInHTMLfile writerHTML = new WriteInHTMLfile();
                leftoverOftext = writerHTML.startHTMLTeg(partWasChanged, nameHTMLFile, path, i, N);
                if (!leftoverOftext.isEmpty()) {
                    iStrings++;
                }
            }
        }
    }
}
