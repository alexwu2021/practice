package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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