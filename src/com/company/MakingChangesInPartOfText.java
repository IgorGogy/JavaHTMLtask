package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public class MakingChangesInPartOfText {

    public ArrayList makingWordsBoldAndItalic(ArrayList<String> partOfTextFromReader, HashSet dicWords, HashSet symbASCII, HashSet lettersASCII) {
        ArrayList<String> partOfTextFromReaderChanged = new ArrayList<>();
        int n = 0; // номер элемента списка partOfTextFromReader
        int n_mainSring = 0; // номер основной строки
        int n_word = 0; // номер последнего слова в предложении в основной строке
        String slovo = null;
        while (n < partOfTextFromReader.size()) {
            System.out.println(partOfTextFromReader.get(n));
            ArrayList<String> small_string = new ArrayList<>(Arrays.asList((partOfTextFromReader.get(n)).split(" ")));// тут создаем AraayList из строки номер n основного ArrayList-a
            System.out.println(partOfTextFromReader.get(0));
            System.out.println(small_string);
            int small_n = 0;
            while (small_n < small_string.size()) {
                String changedWord = null;

                System.out.println(small_string.get(small_n));
                if (!symbASCII.contains(small_string.get(small_n))) { //.trim()!= если отрезанный от начала слова знак равен всему слову значит это слово-символ т.е. изодного только символа типа "-"
                    if (dicWords.contains(small_string.get(small_n).toLowerCase(Locale.ROOT))) {
                        changedWord = ("<b>" + "<i>" + small_string.get(small_n) + "</i>" + "</b>");

                    } else {
                        changedWord = small_string.get(small_n);
                    }
                    if (!(changedWord == null) && small_n == (small_string.size() - 1)) { //строка if будет выполняться, когда changedWord не равна null, и текущее слово является последним словом в предложении в small_string.
                        System.out.println(changedWord); //отладка
                        changedWord = (changedWord + "<br>");
// отладочный код //Fixme WTF?? отладку делают отдельным методом и делают одну глобальную переменную debug=false; и потом
// FixME  ею пользуются переставляя в true и в коде if(debug){calltestMethod(параметры,необходимые,методу}
                        if (changedWord.contains("клетку"))
                            System.out.println(changedWord);
                    }
                    System.out.println(changedWord); //отладка
                    {
                        char[] lettersInWordOfString = small_string.get(small_n).toCharArray();//разбивает на чары не найденное в словаре слово
                        String str_f = "" + small_string.get(small_n).trim().charAt(0);////берет первый чар(символ) и делает его тип String-гом
                        String str_l = "" + small_string.get(small_n).trim().charAt(small_string.get(small_n).length() - 1);//берет посследний чар(символ) и делает его тип String-гом
                        if (symbASCII.contains(str_f) || symbASCII.contains(str_l)) { //проверяем есть ли знаки припенания в слове
                            StringBuilder wordOutOfSymbols = new StringBuilder();
                            StringBuilder symbolsBuck = new StringBuilder();
                            StringBuilder symbolsForward = new StringBuilder();
                            int nuberOfLastLetter = 0;
                            for (int i = 0; i < lettersInWordOfString.length; i++) {
                                String letterNumberItoString = ("" + lettersInWordOfString[i]);//переводим char символ(буква или знак) в String
                                if (lettersASCII.contains(letterNumberItoString)) {  // проверяем не буква ли это
                                    wordOutOfSymbols.append(letterNumberItoString);
                                    nuberOfLastLetter = i;
                                    System.out.println(wordOutOfSymbols);
                                }
                            }
                            for (int i = 0; i < lettersInWordOfString.length; i++) {
                                String letterNumberItoString = ("" + lettersInWordOfString[i]);//переводим char символ(буква или знак) в String
                                if (symbASCII.contains(letterNumberItoString)) {  // проверяем не буква ли это
                                    if (i < nuberOfLastLetter) {
                                        symbolsForward.append(lettersInWordOfString[i]);
                                        System.out.println(symbolsForward);
                                    } else {
                                        symbolsBuck.append(lettersInWordOfString[i]);
                                        System.out.println(symbolsBuck);
                                    }
                                }
                            }
                            if (dicWords.contains(wordOutOfSymbols.toString().toLowerCase(Locale.ROOT))) {
                                changedWord = (symbolsForward + "<b>" + "<i>" + wordOutOfSymbols + "</i>" + "</b>" + symbolsBuck);
                            } else {
                                changedWord = small_string.get(small_n);
                            }
                            if (!(changedWord == null) && small_n == (small_string.size() - 1)) { //(!(changedWord==null) && small_n == (small_string.size() - 1))
                                changedWord = (changedWord + "<br>");
                                if (changedWord == null) {
                                    changedWord = small_string.get(small_n);
                                }
                            }
                        }
                        // ДЕЛАЕМ РАЗРЫВ ПО КОНЦУ ПреДЛОженИЯ
                        // ищем слово с точкой на конце partOfTextFromReader.get(n)

                        // ОКОНЧАТЕЛЬНАЯ ЗАПИСЬ СЛОВА В СТРОК
                        small_string.set(small_n, changedWord);
                        System.out.println(small_string.get(small_n));


                    }
                }
                small_n++;
            }
            // преобразлвываем small_string в строку
            //  int numberOfSentence = 0;

            StringBuilder finalStrings = new StringBuilder(); //создается объект String-говый
            String delim = " "; // разделитель
            int i = 0;
            while (i < small_string.size()) { //

                System.out.println(small_string.get(i));
                finalStrings.append(small_string.get(i));
                if (i != (small_string.size() - 1))
                    finalStrings.append(delim);
                i++;
                System.out.println(finalStrings);
            }
            String res = finalStrings.toString();
            partOfTextFromReaderChanged.add(n, res);
            n++;
        }

        System.out.println(n);
        System.out.println(n_mainSring);
        System.out.println(n_word);
        System.out.println(slovo);
        if (n_mainSring != 0) {
            partOfTextFromReaderChanged.add(Integer.toString(n_mainSring));
            partOfTextFromReaderChanged.add(Integer.toString(n_word));
        }
        System.out.println(partOfTextFromReaderChanged);
        return partOfTextFromReaderChanged;
    }
}
