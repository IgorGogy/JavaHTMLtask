
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public class ChangesInPartOfText {
    public ArrayList makingWordsBoldAndItalic(ArrayList<String> partOfTextFromReader, HashSet dicWords) {
        ArrayList<String> partOfTextFromReaderChanged = new ArrayList<>();
        int n_ofArrayElement = 0; // номер элемента списка partOfTextFromReader
        int n_mainSring = 0; // номер основной строки
        int n_word = 0; // номер последнего слова в предложении в основной строке
        while (n_ofArrayElement < partOfTextFromReader.size()) {
            ArrayList<String> small_string = new ArrayList<>(Arrays.asList((partOfTextFromReader.get(n_ofArrayElement))
                    .split(" ")));// создается AraayList из строки номер n основного ArrayList-a
            int small_n = 0; //номер слова в строке
            while (small_n < small_string.size()) {
                String changedWord = null;
                if (small_string.get(small_n).matches(".*[a-zA-Zа-яА-Я].*")) { // Проверка: если отрезанный от начала слова знак равен всему слову значит это слово-символ т.е. из одного только символа типа "-"
                    if (dicWords.contains(small_string.get(small_n).toLowerCase(Locale.ROOT))) {
                        changedWord = ("<b>" + "<i>" + small_string.get(small_n) + "</i>" + "</b>");
                    } else {
                        changedWord = small_string.get(small_n);
                    }
                    if (!(changedWord == null) && small_n == (small_string.size() - 1)) { //Выполнение строки в случае, когда changedWord не равна null, и текущее слово является последним словом в предложении в small_string.
                        changedWord = (changedWord + "<br>");  }
// отладочный код //Done!//Fixme WTF?? отладку делают отдельным методом и делают одну глобальную переменную debug=false; и потом
// FixME  ею пользуются переставляя в true и в коде if(debug){calltestMethod(параметры,необходимые,методу}
                        char[] lettersInWordOfString = small_string.get(small_n).toCharArray();//разделение на чары не найденное в словаре слово
                        if (!Character.isLetter(small_string.get(small_n).trim().charAt(0)) || !Character.isLetter(small_string.get(small_n).trim().charAt(small_string.get(small_n).length() - 1))) { //проверка есть ли знаки препинания в слове
                            StringBuilder wordOutOfSymbols = new StringBuilder();
                            StringBuilder symbolsBuck = new StringBuilder();
                            StringBuilder symbolsForward = new StringBuilder();
                            int nuberOfLastLetter = 0;
                            for (int i = 0; i < lettersInWordOfString.length; i++) {
                                String letterNumberItoString = ("" + lettersInWordOfString[i]);//перевод char символа(буква или знак) в String
                                if (Character.isLetter(lettersInWordOfString[i])) {  // проверка не буква ли это
                                    wordOutOfSymbols.append(letterNumberItoString);
                                    nuberOfLastLetter = i;
                                }
                            }
                            for (int i = 0; i < lettersInWordOfString.length; i++) {
                                String letterNumberItoString = ("" + lettersInWordOfString[i]);//перевод char символ(буква или знак) в String
                                if (!Character.isLetter(lettersInWordOfString[i])) {  // проверка не буква ли это
                                    if (i < nuberOfLastLetter) {
                                        symbolsForward.append(lettersInWordOfString[i]);
                                    } else {
                                        symbolsBuck.append(lettersInWordOfString[i]);
                                    }
                                }
                            }
                            if (dicWords.contains(wordOutOfSymbols.toString().toLowerCase(Locale.ROOT))) {
                                changedWord = (symbolsForward + "<b>" + "<i>" + wordOutOfSymbols + "</i>" + "</b>" + symbolsBuck);
                            } else {
                                changedWord = small_string.get(small_n);
                            }
                            if (!(changedWord == null) && small_n == (small_string.size() - 1)) {
                                changedWord = (changedWord + "<br>");
                                if (changedWord == null) {
                                    changedWord = small_string.get(small_n);
                                }
                            }
                        }

                        // ОКОНЧАТЕЛЬНАЯ ЗАПИСЬ СЛОВА В СТРОК
                        small_string.set(small_n, changedWord);
                }
                small_n++;
            }
            // преобразование small_string в строку
            StringBuilder finalStrings = new StringBuilder(); //создание объекта String
            String delitel = " "; // разделитель
            int i = 0;
            while (i < small_string.size()) {
                finalStrings.append(small_string.get(i));
                if (i != (small_string.size() - 1))
                    finalStrings.append(delitel);
                i++;
            }
            String summingStringsResult = finalStrings.toString();
            partOfTextFromReaderChanged.add(n_ofArrayElement, summingStringsResult);
            n_ofArrayElement++;
        }
        if (n_mainSring != 0) {
            partOfTextFromReaderChanged.add(Integer.toString(n_mainSring));
            partOfTextFromReaderChanged.add(Integer.toString(n_word));
        }
        return partOfTextFromReaderChanged;
    }
}
