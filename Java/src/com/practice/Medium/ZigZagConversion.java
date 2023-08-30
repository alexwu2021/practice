package com.practice.Medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    /** passed oj, 5ms
     *
     * @param s
     * @param n: numRows
     * @return
     */
    public String convert(String s, int n) {
        if(n <= 1) return s;
        List<StringBuilder> sbs = new ArrayList<>();
        for(int k = 0; k < n; ++k) sbs.add(new StringBuilder());

        int index = 0;
        int j = 1; // incremental
        for(char ch : s.toCharArray()){
            sbs.get(index).append(ch);
            if(index == 0){
                j = 1;
            }
            else if(index == n - 1){
                j = -1;
            }
            index += j;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(StringBuilder sb: sbs) stringBuilder.append(sb.toString());
        return stringBuilder.toString();
    }
}
