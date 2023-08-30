package com.practice.Easy;

import java.util.Stack;

public class ReverseOnlyLetters {

    private boolean isSkippable(char ch){
        if(ch - 'A' < 0 || ch - 'z'> 0)
            return true;
        if(ch -'Z'>0  && ch - 'a' < 0)
            return true;
        return false;
    }


    /**
     * from the leetcode solution
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    /**
     * initial attempt, passed oj, beated 45% in time, 25% in mem
     * @param s
     * @return
     */
    public String reverseOnlyLetters_initial(String s) {
        int i = 0, n = s.length();
        int j = n-1;
        char[] ss = s.toCharArray();
        while (i< j){
            char ch = ss[i];
            if(isSkippable(ch)){
                i++;
                continue;
            }
            while(j >= 0 && isSkippable(ss[j]) && j > i){
                j--;
            }
            if(j <= i)
                break;

            char temp = ss[j];
            ss[j] = ch;
            ss[i] = temp;
            i++;
            j--;
        }
        return String.valueOf(ss);
    }
}
