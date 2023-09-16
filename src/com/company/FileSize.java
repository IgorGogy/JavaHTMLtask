package com.company;

import java.io.File;
public class FileSize {

    public boolean isFileSizeLess2Mb(String path, String filename) {
        File file = new File(path + filename);
        long sizeOfFile = file.length();
        if (sizeOfFile < 2097152L) {
            return true;
        }
        return false;
    }
}
