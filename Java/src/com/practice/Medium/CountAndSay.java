package com.practice.Medium;

public class CountAndSay {

    /** passed oj
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if(n <= 0) return "";
        String s = "1";
        for(int i = 1; i < n; ++i) s = getSay(s);
        return s;
    }

    String getSay(String pre) {
        StringBuilder sb = new StringBuilder();
        int i = 0, count = 0;
        for(; i < pre.length(); ++i){
            count ++;

            //look at one char beyond and to see if there is a shift
            if (i + 1 < pre.length() && (pre.charAt(i) != pre.charAt(i + 1))) {
                sb.append(count).append(pre.charAt(i));
                count = 0;
            }
        }
        sb.append(count).append(pre.charAt(i -1));
        return sb.toString();
    }
}
