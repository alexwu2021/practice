package com.practice.Easy;

import java.util.*;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 */
public class MaxBallons {
    private static String BALLOON = "balloon";
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> mpSrc = new HashMap<>();
        Map<Character, Integer> mpDest = new HashMap<>();
        for(char ch : BALLOON.toCharArray())
            mpSrc.put(ch, mpSrc.getOrDefault(ch, 0) + 1);

        for(char ch : text.toCharArray())
            mpDest.put(ch, mpDest.getOrDefault(ch, 0) + 1);

        List<Integer>quotients = new ArrayList<>();
        for(char ch: mpSrc.keySet()) {
            quotients.add(mpDest.getOrDefault(ch, 0) / mpSrc.get(ch));
        }
        return Collections.min(quotients);
    }
}
