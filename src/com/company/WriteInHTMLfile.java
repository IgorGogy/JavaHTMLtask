package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteInHTMLfile {

    public static ArrayList startHTMLTeg(ArrayList<String> result, String fileName, String stroka, int i) {

        int n;
        n = i;
        int x = 0;
        int y = 0;
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

            // ИЩЕМ СЛОВО С ТОЧКОЙ(ИЛИ ! ?) В КОНЦЕ.

            n_mainSring = 0;
            int n_word = 0;
            int t = 0;
            for (x = 0; x < result.size(); x++) {  //while (t< result.size())
                /*System.out.println(result.get(x));
                System.out.println(result.get(x).contains(". "));
                System.out.println(result.get(x).contains("! "));
                System.out.println(result.get(x).contains("? "));
                System.out.println(result.get(x).contains("!\" "));
                System.out.println(result.get(x).contains("?\" "));*/
                if (result.get(x).contains(". ") || result.get(x).contains("! ") || result.get(x).contains("? ") || result.get(x).contains("!\" ") || result.get(x).contains("?\" ") || result.get(x).contains(".<br>") || result.get(x).contains("!<br>") || result.get(x).contains("?<br>") || result.get(x).contains("!\"<br>") || result.get(x).contains("?\"<br>")) {
                    n_mainSring = x;
                    System.out.println("последняя запись номера строки   " + n_mainSring);
                }
            }

            // нужно поправить, чтобы останавливался посик следующей точки  в строке
            for (int k = 5; k < result.get(n_mainSring).length() - 1; k++) {
                System.out.println(result.get(n_mainSring));
                System.out.println(result.get(n_mainSring).substring(result.get(n_mainSring).length() - k - 2, result.get(n_mainSring).length() - k));
                if (result.get(n_mainSring).endsWith(". ") || result.get(n_mainSring).endsWith("! ") || result.get(n_mainSring).endsWith("? ") || result.get(n_mainSring).endsWith("!\" ") || result.get(n_mainSring).endsWith("?\" ") || result.get(n_mainSring).endsWith(".<br>") || result.get(n_mainSring).endsWith("!<br>") || result.get(n_mainSring).endsWith("?<br>") || result.get(n_mainSring).endsWith("!\"<br>") || result.get(n_mainSring).endsWith("?\"<br>")) {
                    stringForHTML = result.get(n_mainSring);
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

            int a = 0;
            while (n_mainSring > 0) {
                startHTMLTeg.write(result.get(0));
                System.out.println(result.get(0));
                result.remove(0);
                System.out.println(result.get(0));
                n_mainSring--;
            }
            System.out.println(result.get(0));
            // System.out.println(result.get(1));
            // System.out.println(result.get(2));
            if (stringForHTML != null) {
                startHTMLTeg.write(stringForHTML);
            }
            ;
            System.out.println(result);
            if (ostatokStroki != null) {
                result.set(0, ostatokStroki);  // ПРОВЕРИТЬ НУЖНОЛИ!!!
                System.out.println(result);
            } else {
                result.remove(0);
            }

            // Убираем html тэги из строк result

            for (int r = 0; r < result.size(); r++) {
                result.set(r, result.get(r).replaceAll("<b>", "")
                        .replaceAll("<i>", "")
                        .replaceAll("</i>", "")
                        .replaceAll("</b>", "")
                        .replaceAll("<br>", ""));
                System.out.println(result);
            } // Убрали тэги из result


            startHTMLTeg.write("</p> </body> </html>");  // добавляем концовку html файла
        } catch (IOException ex) {
            System.out.println("File has NOT been created");
            System.out.println(ex.getMessage());
        }
        System.out.println(result);
        System.out.println(n_mainSring);
        return result;
    }
}
