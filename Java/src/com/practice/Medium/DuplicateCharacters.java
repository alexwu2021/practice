package com.practice.Medium;

import java.util.*;

public class DuplicateCharacters {

    public String removeDuplicateLetters_naive(String s) {
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); ++i)
            set.add(s.charAt(i));

        List<Character> lst = new ArrayList<>(set);

        Collections.sort(lst);
        StringBuffer sb = new StringBuffer();
        for(Character ch: lst)
            sb.append(ch);
        return sb.toString();
    }


    /** from dwaijam, slightly changed
     * @param sr
     * @return
     */
    public String removeDuplicateLetters(String sr) {

        int[] freq = new int[26]; //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] ca = sr.toCharArray();
        for(char c: ca){  //count number of occurences of character
            freq[c-'a']++;
        }
        Stack<Character> stk = new Stack<>(); // answer stack
        int index;
        for(char ch:ca){
            index= ch-'a';
            freq[index]--;   //decrement number of characters remaining in the string to be analysed
            if(visited[index]) //if character is already present in stack, dont bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while(!stk.isEmpty() && ch<stk.peek() && freq[stk.peek()-'a']!=0){
                visited[stk.pop()-'a']=false;
            }
            stk.push(ch); //add current character and mark it as visited
            visited[index]=true;
        }


        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
