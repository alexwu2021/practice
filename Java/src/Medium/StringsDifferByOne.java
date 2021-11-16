package Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings dict where all the strings are of the same length.
 *
 * Return true if there are 2 strings that only differ by 1 character in the same index, otherwise return false.
 *
 *
 *
 * Example 1:
 *
 * Input: dict = ["abcd","acbd", "aacd"]
 * Output: true
 * Explanation: Strings "abcd" and "aacd" differ only by one character in the index 1.
 * Example 2:
 *
 * Input: dict = ["ab","cd","yz"]
 * Output: false
 * Example 3:
 *
 * Input: dict = ["abcd","cccc","abyd","abab"]
 * Output: true
 */
public class StringsDifferByOne {
    public boolean differByOne(String[] dict){
        Set<String> st = new HashSet<>();
        int len = dict[0].length();
        for(int i = 0; i < len; ++i){
            st.clear();
            for(String str: dict){
                String t = str.substring(0, i) + str.substring(i + 1, len);
                if(st.contains(t))
                    return true;
                st.add(t);
            }
        }
        return false;
    }


    public boolean differByOne_will_fail_on_large_ds(String[] dict) {
        int len = dict[0].length();
        for(int i=0; i<dict.length-1; ++i){
            for(int j=i+1; j<dict.length; ++j){
                int count = 0;
                for(int k=0; k<len; ++k){
                    int temp = (int)dict[i].charAt(k) ^ (int)dict[j].charAt(k);
                    if(temp >= 1){
                        count++;
                        System.out.println(" i " + dict[i] + " and j " + dict[j] + " diffs at " + k);
                    }
                }
                if(count == 1) return true;
            }
        }
        return false;
    }
}
