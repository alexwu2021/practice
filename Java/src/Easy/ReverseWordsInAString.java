package Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Must retaining the original spacing
 */
public class ReverseWordsInAString {

    /**
     * Runtime: 6 ms, faster than 56.34% of Java online submissions for Reverse Words in a String.
     * Memory Usage: 37.6 MB, less than 85.53% of Java online submissions for Reverse Words in a String.
     * @param s
     * @return
     */
    public String reverseWords_ModernWay(String s) {
        if(s == null || s.length() <= 0) return s;
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


    /** OJ passed
     *
     * Runtime: 7 ms, faster than 46.27% of Java online submissions for Reverse Words in a String.
     * Memory Usage: 37.5 MB, less than 91.92% of Java online submissions for Reverse Words in a String.
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if(s == null || s.length() <= 0) return s;

        StringBuilder sb = new StringBuilder();
        Stack<String>stk = new Stack<>();
        for(String str: s.trim().split(" +"))
            stk.push(str);
        while(!stk.isEmpty())
            sb.append(stk.pop()).append(" ");
        return sb.toString().trim();
    }

    void swap(char[] arr, int a, int b) {
        char temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    void reverseAWord(char[] arr, int start, int end){
        int len = end - start + 1, mid = len >> 1;
        for(int i = 0; i < mid; ++i){
            swap(arr, start + i, end - i);
        }
    }

    /** In this version, the spacings between words are retained, however, the leading and treailing ws
     *  are still trimmed off.
     * @param s
     * @return
     */
    public String reverseWords_RetainWhiteSpacings(String s) {
        if(s == null || s.length() <= 0) return s;
        char[] arr = (new StringBuilder(s.trim())).reverse().toString().trim().toCharArray();
        int i = 0, j = 0, n = arr.length;
        while(i < n && j < n){
            while(j < n && arr[j] == ' '){
                j++;
            }
            i = j;
            while(j < n && arr[j] != ' '){
                j++;
            }
            reverseAWord(arr, i, j-1);
        }
        return new String(arr);
    }
}
