package com.docmatter.ims.util;

public class ImsStringUtil {
    public static String treatItToBeOneLiner(String val) {
        String ret = val.replace("\n", "")
                .replace(",", "-")
                .replace(" ", "_")
                .replace("<i>", "").replace("</i>", "")
                .replace("<br>", "").replace("</br>", "");
        return ret;
    }
}
