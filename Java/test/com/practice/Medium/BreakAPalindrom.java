package com.practice.Medium;

/**
 * Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
 *
 * Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
 *
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.
 *
 *
 */
public class BreakAPalindrom {

    boolean isPalin(String s){
        int n = s.length();
        if(n == 1) return true;
        int i = 0, j = n - 1;
        while(i < n && j >= 0 && i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    /** coded this up based on the hints
     * @param palindrome speed beats 100%; mem beats 54%
     * @return
     */
    public String breakPalindrome(String palindrome) {
        if(palindrome == null || palindrome.length() <= 1)
            return "";
        char[] sa = palindrome.toCharArray();
        int i = 0, len = sa.length;
        char previousChar;

        do {
            while(i < len && sa[i] == 'a') i++;

            if(i < len) {
                previousChar = sa[i];
                sa[i] = 'a';
                String temp = String.valueOf(sa);
                if(!isPalin(temp)){
                    break;
                }
                sa[i] = previousChar;
                i++;
            } else {
                sa[len-1] = 'b';
                break;
            }
        } while(true);

        return String.valueOf(sa);
    }


    public String breakPalindrome_kniffina(String palindrome) {
        char[] s = palindrome.toCharArray();
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return String.valueOf(s);
            }
        }
        s[n - 1] = 'b'; //if all 'a'
        return n < 2 ? "" : String.valueOf(s);
    }
}
