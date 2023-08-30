package com.practice.Easy;

/**
 * Given an input string , reverse the string word by word.
 *
 * Example:
 *
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Words in a String II.
 * Memory Usage: 44.2 MB, less than 9.64% of Java online submissions for Reverse Words in a String II.
 */
public class ReverseWordsInString2 {

    static final char WS = ' ';

    public void reverseWords(char[] arr) {
        if(arr == null || arr.length <= 1) return;

        int i = 0, j = 0, n = arr.length;
        reverseAWord(arr, 0, n - 1);
        while(i < n && j < n){
            while(j < n && arr[j] == WS){ j++; }
            i = j;
            while(j < n && arr[j] != WS){ j++; }
            reverseAWord(arr, i, j - 1);
        }
    }

    void reverseAWord(char[] arr, int start, int end){
        int mid = (end - start + 1) >> 1;
        for(int i = 0; i < mid; ++i){
            swap(arr, start + i, end - i);
        }
    }

    void swap(char[] arr, int a, int b) {
        char temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
