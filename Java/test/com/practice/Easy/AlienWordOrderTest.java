package com.practice.Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlienWordOrderTest {

    @Test
    public void isAlienSorted() {
        AlienWordOrder alienWordOrder = new AlienWordOrder();
        String order;
        String[] words;
        boolean expected, actual;

//        words = new String[]{"hello","leetcode"};
//        order = new String("hlabcdefgijkmnopqrstuvwxyz");
//        actual = alienWordOrder.isAlienSorted(words, order);
//        expected = true;
//        assert(actual == expected);
//
//        words = new String[]{"word","world","row"};
//        order = new String("worldabcefghijkmnpqstuvxyz");
//        actual = alienWordOrder.isAlienSorted(words, order);
//        expected = false;
//        assert(actual == expected);
//
//        words = new String[]{"apple","app"};
//        order = new String("abcdefghijklmnopqrstuvwxyz");
//        actual = alienWordOrder.isAlienSorted(words, order);
//        expected = false;
//        assert(actual == expected);


        words = new String[]{"kuvp","q"};
        order = new String("ngxlkthsjuoqcpavbfdermiywz");
        actual = alienWordOrder.isAlienSorted(words, order);
        expected = true;
        assert(actual == expected);

    }
}