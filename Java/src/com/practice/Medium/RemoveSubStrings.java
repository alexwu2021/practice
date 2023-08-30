package com.practice.Medium;

import java.util.Stack;

/**
 * 1910. Remove All Occurrences of a Substring
 * Medium
 *
 * 312
 *
 * 24
 *
 * Add to List
 *
 * Share
 * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
 *
 * Find the leftmost occurrence of the substring part and remove it from s.
 * Return s after removing all occurrences of part.
 *
 * A substring is a contiguous sequence of characters in a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "daabcbaabcbc", part = "abc"
 * Output: "dab"
 * Explanation: The following operations are done:
 * - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
 * - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
 * - s = "dababc", remove "abc" starting at index 3, so s = "dab".
 * Now s has no occurrences of "abc".
 * Example 2:
 *
 * Input: s = "axxxxyyyyb", part = "xy"
 * Output: "ab"
 * Explanation: The following operations are done:
 * - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
 * - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
 * - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
 * - s = "axyb", remove "xy" starting at index 1 so s = "ab".
 * Now s has no occurrences of "xy".
 */
public class RemoveSubStrings {

    public String removeOccurrences_plain(String s, String part) {
        while (true) {
            int i = s.indexOf(part);
            if (i == -1) return s;
            s = s.substring(0, i) + s.substring(i + part.length());
        }
    }

    /**
     * Runtime: 3 ms
     * Memory Usage: 40.6 MB
     *  chiranjeeb2
     * @param s
     * @param part
     * @return
     */
    public String removeOccurrences(String s, String part) {
        int[] kmpPattern = findKmpPattern(part);

        // using stack to easily delete characters when a pattern is found.
        Stack<Character> stack = new Stack<>();

        // using index array to store 'j' (index of part) so that after character deletion we can resume
        int[] idxArr = new int[s.length() + 1];

        for(int i=0, j=0; i<s.length(); i++){
            char ch = s.charAt(i);
            stack.push(ch);

            if(ch == part.charAt(j)){
                // storing the next index of 'j'
                idxArr[stack.size()] = ++j;

                if(j == part.length()){
                    // deleting character when a pattern match is found
                    int count = part.length();
                    while(count != 0){
                        stack.pop();
                        count--;
                    }

                    // restoring the index of 'j' for finding next pattern.
                    j = stack.isEmpty() ? 0 : idxArr[stack.size()];
                }
            }
            else{
                if(j != 0){
                    i--;
                    j = kmpPattern[j-1];
                    stack.pop();
                }
                else {
                    // if the current stack is not empty and j == 0, we need to correct the previously stored index of 'j'
                    idxArr[stack.size()] = 0;
                }
            }
        }

        // Creating a string out of the left over characters in the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private int[] findKmpPattern(String s){
        int[] arr = new int[s.length()];
        for(int i=1, j=0; i<s.length(); ){
            if(s.charAt(i) == s.charAt(j)){
                arr[i] = ++j;
                i++;
            }
            else if(j != 0){
                j = arr[j-1];
            }
            else{
                i++;
            }
        }
        return arr;
    }
}
