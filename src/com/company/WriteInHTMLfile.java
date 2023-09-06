package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteInHTMLfile {

    public static int startHTMLTeg(ArrayList<String> result, String fileName, String stroka, int i) {
        int jj;
        jj = i;
        try (BufferedWriter startHTMLTeg = new BufferedWriter(new FileWriter((stroka + (fileName + jj + ".html"))))) {
            startHTMLTeg.write("<html>\n" +
                    " <head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title>Тег META, атрибут charset</title>\n" +
                    " </head>\n" +
                    " <body> \n" +
                    "  <p>");
           // String partOfText = null;
            System.out.println(result);
            StringBuilder finalStrings = new StringBuilder();
            String delim = "";
            int ii=0;
            while (ii<result.size()) {
                finalStrings.append(result.get(ii));
                finalStrings.append(delim);
                ii++;
            }
            String res = finalStrings.toString();
            System.out.println(finalStrings);
            System.out.println(result);
            System.out.println(res);
            //partOfText = result.toString();
          //  String partOfText = (String.valueOf(result));
         //   System.out.println(partOfText);
            startHTMLTeg.write(res);
            //result.setLength(0);
            startHTMLTeg.write("</p> </body> </html>");
        } catch (IOException ex) {
            System.out.println("File has NOT been created");
            System.out.println(ex.getMessage());
        }
        return jj;
    }




}
