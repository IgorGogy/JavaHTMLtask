package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MakingChangesInPartOfText {

    public ArrayList makingWordsBoldAndItalic(ArrayList<String> partOfTextFromReader, HashSet dicWords, HashSet symbASCII, HashSet lettersASCII) {
        ArrayList<String> partOfTextFromReaderChanged = new ArrayList<>();
        int n = 0; // номер элемента списка partOfTextFromReader    .trim()
        while (n < partOfTextFromReader.size()) {
            ArrayList<String> small_string = new ArrayList<>(Arrays.asList((partOfTextFromReader.get(n)).split(" ")));// тут создаем AraayList из строки номер n основного ArrayList-a
            System.out.println(partOfTextFromReader.get(0));
            System.out.println(small_string);
            int small_n = 0;
            String wordForArray = null;
            while (small_n < small_string.size()) {
                String changedWord = null;

                //   boolean equalsOfWords = dicWords.contains(small_string.get(small_n));
                if (!symbASCII.contains(small_string.get(small_n))) { //.trim()!= если отрезанный от начала слова знак равен всему слову значит это слово-символ т.е. изодного только символа типа "-"
                    if (dicWords.contains(small_string.get(small_n).trim())) {
                        changedWord = ("<b>" + "<i>" + small_string.get(small_n) + "</i>" + "</b>");
                    } else {
                        changedWord = small_string.get(small_n);
                    }
                    // if ((small_n == (small_string.size() - 1))) && !(changedWord ==null) {
                    if (!(changedWord == null) && small_n == (small_string.size() - 1)) {
                        changedWord = (changedWord + "<br>");
                    }
                    /*{ //проверяется слово номер small_n элемента(строки) small_string в словаре dicWords и возвращается true/false в if
                        small_string.set(small_n, ("<b>" + "<i>" + small_string.get(small_n) + "</i>" + "</b>"));
                        if (small_n == small_string.size() - 1)
                            small_string.set(small_n, (small_string.get(small_n) + "<br>"));
                    } else */
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
                            if (dicWords.contains(wordOutOfSymbols.toString())) {
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
                        System.out.println(changedWord);
                        System.out.println((partOfTextFromReader.get(n)).toCharArray());
                        if (((partOfTextFromReader.get(n)).contains(". ")) || ((partOfTextFromReader.get(n)).contains("! ")) || ((partOfTextFromReader.get(n)).contains("? "))){
                            //  String lastLetter = changedWord.substring(changedWord.length()-1, changedWord.length()); // поиск точки в конце слова
                            //if (lastLetter.equals(">")){
                            //  lastLetter = changedWord.substring(changedWord.length() - 5, changedWord.length() - 4); // поиск точки в конце слова<br>
                        //}
                            // выше нашли слово с . или !? +пробел на конце
                         String stroka = (partOfTextFromReader.get(n)).toString();
                            System.out.println(stroka);
                            System.out.println(stroka.length());
                            System.out.println(partOfTextFromReader.get(n).length());


                         for (int i=(partOfTextFromReader.get(n).length()); i>2; i--){
                             System.out.println(stroka);
                             System.out.println(stroka.substring((i-2), i));
                             System.out.println(stroka.substring(i, (partOfTextFromReader.get(n).length())));
                         if ((stroka.substring((i-2), i)).equals(". ") || (stroka.substring((i-2), i)).equals("! ") || (stroka.substring((i-2), i)).equals("? ")){
                                 System.out.println("вот оно то самое!  " + "\"" + stroka.substring((i-2), i)+ "\"");
                             }
                             System.out.println(stroka.substring((i-2), i) );
                         }
                            small_string.set(small_n, changedWord); // записываем найденное последнее "слово. " в строку       System.out.println(small_string.get(small_n));
                           break;

                        }






                            // ОКОНЧАТЕЛЬНАЯ ЗАПИСЬ СЛОВА В СТРОК
                        small_string.set(small_n, changedWord);
                        System.out.println(small_string.get(small_n));


                    }
                }
                small_n++;
            }
            // преобразлвываем small_string в строку
            int numberOfSentence = 0;

            StringBuilder finalStrings = new StringBuilder(); //создается объект String-говый
            String delim = " "; // разделитель
            int i = 0;
            while (i < small_string.size()) { //
                // ниже выясняем является ли последний символ слова точкой(!?.) с пробелом
/*
                String[] words = (small_string.get(i)).split(" "); // разделяем строку на массив слов "\s+" && Character.isUpperCase(word.charAt(0))
                System.out.println(small_string.get(i));
                for (int j=0; j< words.length; j++) {  //(String word : words)
                    System.out.println(words[j]);
                    String word = words[j];
                    System.out.println(word);
                    if (!word.isEmpty() && word.charAt(word.length()-1)=='.' || word.charAt(word.length()-1)=='!' || word.charAt(word.length()-1)=='?') {
                            numberOfSentence++;


                        */
/*hasCapitalizedWords = true;
                        break; // Если найдено хотя бы одно слово с заглавной буквой, выходим из цикла*//*

                    }
                }
*/
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


        // ниже код для эксперементов
/*

        if (partOfTextFromReaderChanged.toString().contains("."))
        System.out.println(partOfTextFromReaderChanged);
        String ssxx = null;
        ssxx = partOfTextFromReaderChanged.get(0);
        System.out.println(ssxx);
        ssxx = new String(String.valueOf(Arrays.asList((partOfTextFromReaderChanged.get(0)).split(" "))));
        System.out.println(ssxx);
        ssxx = new String(String.valueOf(Arrays.asList((partOfTextFromReaderChanged.get(0)).split("\\\\s+"))));
        System.out.println(ssxx);
*/


        //  if (partOfTextFromReaderChanged.get(5).contains("."))
        //   ArrayList<String> textString = new ArrayList<>(Arrays.asList((partOfTextFromReaderChanged.get(5)).split(" ")));
        //   String textString = partOfTextFromReaderChanged.get(5).split(" ");



  /*      if (partOfTextFromReaderChanged.toString().contains("."))
            System.out.println("есть");
        System.out.println("нет");
        System.out.println(partOfTextFromReaderChanged);*/
        return partOfTextFromReaderChanged; //boldedpart;
    }
}
