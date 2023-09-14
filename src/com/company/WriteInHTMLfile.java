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
        try (BufferedWriter startHTMLTeg = new BufferedWriter(new FileWriter((stroka + (fileName + n + ".html"))))) {
            startHTMLTeg.write("<html>\n" +
                    " <head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title>Тег META, атрибут charset</title>\n" +
                    " </head>\n" +
                    " <body> \n" +
                    "  <p>");

            // этод блок обрабатывает последний кусток исходного текста, он просто записывает его в html файл как есть.
            System.out.println(result.size());
            if (result.size()<N) {
             for (int w=0; w<=result.size()-1; w++)  {
                 System.out.println(result.get(w));
                 startHTMLTeg.write(result.get(w));
                }
                result.clear();


            } else {
            // ИЩЕМ СЛОВО С ТОЧКОЙ(ИЛИ ! ?) В КОНЦЕ.
            n_mainSring = 0;
            System.out.println(result);
            System.out.println(result.size());
            for (x = 0; x < result.size(); x++) {  //
                System.out.println(result.get(x));
               if (result.get(x).contains(". ") || result.get(x).contains("! ") || result.get(x).contains("? ") || result.get(x).contains("!\" ") || result.get(x).contains("?\" ") || result.get(x).contains(".<br>") || result.get(x).contains("!<br>") || result.get(x).contains("?<br>") || result.get(x).contains("!\"<br>") || result.get(x).contains("?\"<br>")) {
                    n_mainSring = x;
                    System.out.println("последняя запись номера строки   " + n_mainSring);
                }
            }

            System.out.println(result.get(n_mainSring).length() - 1);
            for (int k = 5; k < result.get(n_mainSring).length() - 1; k++) {
                System.out.println(result.get(n_mainSring));
                System.out.println(result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, result.get(n_mainSring).length() - k));
                if (result.get(n_mainSring).endsWith(". ") || result.get(n_mainSring).endsWith("! ") || result.get(n_mainSring).endsWith("? ") || result.get(n_mainSring).endsWith("!\" ") || result.get(n_mainSring).endsWith("?\" ") || result.get(n_mainSring).endsWith(".<br>") || result.get(n_mainSring).endsWith("!<br>") || result.get(n_mainSring).endsWith("?<br>") || result.get(n_mainSring).endsWith("!\"<br>") || result.get(n_mainSring).endsWith("?\"<br>")) {
                    stringForHTML = result.get(n_mainSring);
                    k = result.get(n_mainSring).length() - 1;
                } else {
                    if (result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, (result.get(n_mainSring)).length() - k).equals(". ") ||
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
                        //  ostatokStroki="хрень -*-<b><i>ура</i></b>!/ *Файл_с_текстом+     (<b><i>содержит</i></b>    карра+ (<b><i>текст</i></b>\")*<br>";
                        ostatokStroki = ostatokStroki.replaceAll("<b>", "")
                                .replaceAll("<i>", "")
                                .replaceAll("</i>", "")
                                .replaceAll("</b>", "")
                                .replaceAll("<br>", "");
                        System.out.println(ostatokStroki);
                        k = result.get(n_mainSring).length() - 1;

                    }
                    System.out.println(stringForHTML);
                    System.out.println(ostatokStroki);
                    System.out.println(n_mainSring);
                    System.out.println("hhhhh");
                }
            }

           // в этом блоке записываем в html файл все строки из result кроме последней строки,
           //  последняя строка разделится(не в этом блоке) на 2 части, 1я часть то же запишется в html файл, вторая часть останется в result
            while (n_mainSring > 0) {
                startHTMLTeg.write(result.get(0));
                System.out.println(result.get(0));
                result.remove(0);
                System.out.println(result.get(0));
                n_mainSring--;
            }// записали.
            // тут записываем в html файл часть последней строки, эта часть строки это концовка последнего предложения
            System.out.println(result.get(0));
             if (stringForHTML != null) {
                startHTMLTeg.write(stringForHTML);
            };
             // в этом блоке записываем значени 2й части последней строки в нулевой элемент ArrayList-а result
            System.out.println(result);
            if (ostatokStroki != null) {
                result.set(0, ostatokStroki);  // ПРОВЕРИТЬ НУЖНОЛИ!!!
                System.out.println(result);
            } else {
                result.remove(0); // тут удаляем нулевой элемент ArrayList-а result, т.к. в данной ситуации вся последняя строка записалась в html
            }

            // Убираем html тэги из отсавшихся строк result

            for (int r = 0; r < result.size(); r++) {
                result.set(r, result.get(r).replaceAll("<b>", "")
                        .replaceAll("<i>", "")
                        .replaceAll("</i>", "")
                        .replaceAll("</b>", "")
                        .replaceAll("<br>", ""));
                System.out.println(result);
            } // Убрали тэги из result
            }
            // добавляем концовку html файла
            startHTMLTeg.write("</p> </body> </html>");

        } catch (IOException ex) {
            System.out.println("File has NOT been created");
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
