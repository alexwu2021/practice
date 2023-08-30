package com.practice.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiftingLetters {

    private static Map<Character, Integer> char2Index = new HashMap<>();
    private static Map<Integer, Character>index2Char = new HashMap<>();

    public ShiftingLetters(){
        if(char2Index.size() == 0){
            int j = 0;
            for(int i = 'a'; i<='a' + 25; ++i){
                char2Index.put((char)i , j);
                index2Char.put(j, (char)i);
                j++;
            }
        }
    }

    /**
     * the auther is jontystanley21
     * @param s
     * @param shifts
     * @return
     */
    public String shiftingLetters_ref(String s, int[] shifts) {
        StringBuilder ans = new StringBuilder(s);
        long shift=0;
        for (int i = s.length()-1; i >=0 ; i--){
            ans.setCharAt(i, (char)((s.charAt(i) - 'a' + (shift+shifts[i]) % 26) % 26 + 'a'));
            shift+=shifts[i];
        }
        return ans.toString();
    }


    /** author: Alan24
     * close to my thinking
     * @param s
     * @param shifts
     * @return
     */
    public String shiftingLetters_ref2(String s, int[] shifts) {
        // calculate the total shifts
        for(int i=shifts.length-1; i>0; --i){
            shifts[i-1] += shifts[i]; // add up the shift
            shifts[i-1] %= 26; // check for integer overflow
        }
        char[] charArr = s.toCharArray();
        for(int i=0; i<s.length(); ++i){
            charArr[i] = (char)('a'+(charArr[i]-'a' + shifts[i])%26);
        }
        return String.valueOf(charArr);
    }

    /** my first implementation, passed OJ, beat 14%
     * @param s
     * @param shifts
     * @return
     */
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder ret = new StringBuilder();

        List<Character> list = new ArrayList<>();
        for(int k=0; k<s.length(); ++k)
            list.add(s.charAt(k));

        int[] accumulated = new int[shifts.length];
        for(int p = 0; p<shifts.length; ++p){
            accumulated[p] = (shifts[p]) % 26;
        }

        for(int p = shifts.length-2; p>=0; --p){
            accumulated[p] = (accumulated[p] +  accumulated[p+1]) % 26;
        }

        ShiftThem(list, accumulated);

        for (Character ch : list) {
            ret.append(ch);
        }
        return ret.toString();
    }

    private Character shift(char c, int i){
        return index2Char.get((char2Index.get(c) + i) % 26);
    }

    private void ShiftThem(List<Character>list, int[] accumulated){
        for(int i=0; i< list.size(); ++i){
            list.set(i, shift(list.get(i), accumulated[i]));
        }
    }
}
