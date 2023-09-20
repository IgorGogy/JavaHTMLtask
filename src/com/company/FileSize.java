package com.company;

import java.io.File;

public class FileSize {

    public boolean isFileSizeLess2Mb(String path, String filename) {
        File file = new File(path + filename);
        long sizeOfFile = file.length();
        if (sizeOfFile < 2097152L && sizeOfFile > 0) {
            return true;
        } else
            if (sizeOfFile==0) {
                System.out.println("Отсутствует файл  " + path + filename);
            }else
        System.out.println("Превышен размер файл  " + path + filename);

        return false;
    }
}
