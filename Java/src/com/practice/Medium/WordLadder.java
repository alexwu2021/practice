package com.practice.Medium;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of s
 * hortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) return 0;
        int ln = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> v = new HashSet<>(); // visited
        q.offer(beginWord);
        v.add(beginWord);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            ln += levelSize != 0 ? 1 : 0;
            for (int i = 0; i < levelSize; ++i) {
                String curr = q.poll();
                if (curr.equals(endWord))
                    return ln;
                char[] chars = curr.toCharArray();
                for (int j = 0; j < chars.length; ++j) {
                    char prevChar = chars[j];
                    for (char nextChar = 'a'; nextChar <= 'z'; ++nextChar) {
                        chars[j] = nextChar;
                        String nextWord = new String(chars);
                        if (dictionary.contains(nextWord) && !v.contains(nextWord)) {
                            q.offer(nextWord);
                            v.add(nextWord);
                        }
                    }
                    chars[j] = prevChar;
                }
            }
        }
        return 0;
    }
}
