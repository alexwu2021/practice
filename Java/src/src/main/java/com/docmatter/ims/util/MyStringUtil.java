package com.docmatter.ims.util;

public class MyStringUtil {

    public static String removeTrailingComma(String s) {
        if(s == null) return s;
        int index=s.length() - 1;
        while(index >= 0 && s.charAt(index) == ' ')
            index--;
        if(index >= 0 && s.charAt(index) == ',')
            index--;
        return s.substring(0, index + 1);
    }
}
