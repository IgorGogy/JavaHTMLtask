package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteInHTMLfile {

    public static ArrayList startHTMLTeg(ArrayList<String> result, String fileName, String stroka, int i, int N) {

        int n;
        n = i;
        int x = 0;
        String stringForHTML = null; //переменная для записи остатка строки
        String ostatokStroki = null; // остаток строки который нужно оставить в списке
        System.out.println(stroka);
        int n_mainSring = 0;
        try (BufferedWriter startHTMLTag = new BufferedWriter(new FileWriter((stroka + (fileName + n + ".html"))))) {
            startHTMLTag.write(  "<!DOCTYPE html>\n" +
                    "<html lang=\"ru\">\n" +
                    " <head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title>Тег META, атрибут charset</title>\n" +
                    " </head>\n" +
                    " <body> \n" +
                    "  <p>");
            // Обработка последней части исходного текста. Данная часть записывается в html файл как есть.
            if (result.size()<N) {
             for (int w=0; w<=result.size()-1; w++)  {
                 startHTMLTag.write(result.get(w));
                }
                result.clear();
            } else {
            // поиск слова с точкой (или ! ?) в конце строки.
            n_mainSring = 0;
            for (x = 0; x < result.size(); x++) {  //
               if (result.get(x).contains(". ") || result.get(x).contains("! ") || result.get(x).contains("? ") || result.get(x).contains("!\" ") || result.get(x).contains("?\" ") || result.get(x).contains(".<br>") || result.get(x).contains("!<br>") || result.get(x).contains("?<br>") || result.get(x).contains("!\"<br>") || result.get(x).contains("?\"<br>")) {
                    n_mainSring = x;
                }
            }
            for (int k = 5; k < result.get(n_mainSring).length() - 1; k++) {
                if (result.get(n_mainSring).endsWith(". ") || result.get(n_mainSring).endsWith("! ") || result.get(n_mainSring).endsWith("? ") || result.get(n_mainSring).endsWith("!\" ") || result.get(n_mainSring).endsWith("?\" ") || result.get(n_mainSring).endsWith(".<br>") || result.get(n_mainSring).endsWith("!<br>") || result.get(n_mainSring).endsWith("?<br>") || result.get(n_mainSring).endsWith("!\"<br>") || result.get(n_mainSring).endsWith("?\"<br>")) {
                    stringForHTML = result.get(n_mainSring);
                    k = result.get(n_mainSring).length() - 1;
                } else {
                    if     (result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals(". ") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals("! ") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals("? ") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals("?\"") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals("!\"") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals(".<") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals("!<") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals("?<") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals("?\"<") ||
                            result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals("!\"<")) {  // тут сравниваем ровняется ли кусок строки (х) знакам припенания конца предложеия
                        stringForHTML = result.get(n_mainSring).substring(0, result.get(n_mainSring).length() - k - 2 + 2);
                        ostatokStroki = result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2 + 2);
                        ostatokStroki = ostatokStroki.replaceAll("<b>", "")
                                .replaceAll("<i>", "")
                                .replaceAll("</i>", "")
                                .replaceAll("</b>", "")
                                .replaceAll("<br>", "");
                        k = result.get(n_mainSring).length() - 1;
                    }
                }
            }
           // в этом блоке запись в html файл все строки из result кроме последней строки,
           // последняя строка делится(не в этом блоке) на 2 части, 1я часть то же пишется в html файл, вторая часть остается в result
            while (n_mainSring > 0) {
                startHTMLTag.write(result.get(0));
                result.remove(0);
                n_mainSring--;
            }
            //  запись в html файл часть последней строки, эта часть строки это концовка последнего предложения
             if (stringForHTML != null) {
                startHTMLTag.write(stringForHTML);
            };
             // запись значения 2й части последней строки в нулевой элемент ArrayList-а result
            if (ostatokStroki != null) {
                result.set(0, ostatokStroki);
            } else {
                result.remove(0); //  удаление нулевого элемента ArrayList-а result, т.к. в данной ситуации вся последняя строка записывается в html
            }
            // Удаление html тэгов из оставшихся строк result
            for (int r = 0; r < result.size(); r++) {
                result.set(r, result.get(r).replaceAll("<b>", "")
                        .replaceAll("<i>", "")
                        .replaceAll("</i>", "")
                        .replaceAll("</b>", "")
                        .replaceAll("<br>", ""));
            }
            }
            // добавление завершающих html файла тэгов
            startHTMLTag.write("</p>\n" +  "</body>\n" +  "</html>\n");
        } catch (IOException ex) {
            System.out.println("File has NOT been created");
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
