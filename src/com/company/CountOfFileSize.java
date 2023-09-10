package com.company;

import java.io.File;

public class CountOfFileSize {

    public boolean isFileSizeLess2Mb(String path, String filename) {
        File file = new File(path + filename);
        long dlinna = file.length();
        if (dlinna < 2097152L) {
            return true;
        }
        return false;
    }


}
