package com.practice.Easy;

import java.util.*;

/**
 * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
 *
 * There are two types of logs:
 *
 * Letter-logs: All words (except the identifier) consist of lowercase English letters.
 * Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 *
 * The letter-logs come before all digit-logs.
 * The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
 * The digit-logs maintain their relative ordering.
 * Return the final order of the logs.
 *
 *
 */
public class ReorderDataInLogFiles {

    /**
     * from browntiger
     * @param logs
     * @return
     */
    public String[] reorderLogFiles_preferred(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. bring letter to forward.
                return 1;
            } else {
                //first is letter, second is digit. keep them in this order.
                return -1;
            }
        });
        return logs;
    }


    public String[] reorderLogFiles(String[] logs) {
        List<String> ans = new ArrayList<>();
        if(logs == null || logs.length <= 0) return ans.toArray(new String[0]);

        List<String> digits = new ArrayList<>();
        Queue<String[]> pq = new PriorityQueue<>(
                (a, b)->( a[1].equals(b[1]) ? a[0].compareTo(b[0]) : a[1].compareTo(b[1]))
        );
        for(String lg : logs){
            String[] sa = new String[2];
            if(classify(sa, lg)) digits.add(lg);
            else pq.offer(sa);
        }
        while(!pq.isEmpty()){
            String[] temp = pq.poll();
            ans.add(temp[0] + " " + temp[1]);
        }
        ans.addAll(digits);
        return ans.toArray(new String[ans.size()]);
    }

    private boolean classify(String[] result, String s){
        boolean isDigit = true;
        String[] sa = s.split(" ");
        result[0] = sa[0];
        result[1] = "";
        if(!Character.isDigit(sa[1].charAt(0)))
            isDigit = false;
        for(int i=1; i<sa.length-1; ++i)
            result[1] += sa[i] + " ";
        result[1] += sa[sa.length-1];
        return isDigit;
    }
}