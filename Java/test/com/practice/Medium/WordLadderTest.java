package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordLadderTest {

    @Test
    public void ladderLength() {
        String beginWord;
        String endWord;
        WordLadder sol = new WordLadder();
        List<String> inputs;
        int actual, expected;

//        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//        Output: 5
//        Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
//        Example 2:
        inputs = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        beginWord = "hit";
        endWord = "cog";
        actual = sol.ladderLength(beginWord, endWord, inputs);
        expected = 5;
        Assert.assertEquals(expected, actual);

//        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//        Output: 0
//        Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
        inputs = Arrays.asList(new String[]{"hot","dot","dog","lot","log"});
        beginWord = "hit";
        endWord = "cog";
        actual = sol.ladderLength(beginWord, endWord, inputs);
        expected = 0;
        Assert.assertEquals(expected, actual);


//        "red"
//        "tax"
//                ["ted","tex","red","tax","tad","den","rex","pee"]
//
        inputs = Arrays.asList(new String[]{"ted","tex","red","tax","tad","den","rex","pee"});
        beginWord = "red";
        endWord = "tax";
        actual = sol.ladderLength(beginWord, endWord, inputs);
        expected = 4;
        Assert.assertEquals(expected, actual);

    }
}