package com.practice.Hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberToWordsTest {

    @Test
    public void numberToWords() {

        NumberToWords numberToWords = new NumberToWords();
        int Input;
        String Output, res;

        Input = 1000000;
        res = numberToWords.numberToWords(Input);
        Output = "One Million";
        assert(res.equals(Output));


        Input = 111;
        res = numberToWords.numberToWords(Input);
        Output = "One Hundred Eleven";
        assert(res.equals(Output));


        Input = 50868;
        res = numberToWords.numberToWords(Input);
        Output = "Fifty Thousand Eight Hundred Sixty Eight";
        assert(res.equals(Output));


        Input = 12345;
        Output = "Twelve Thousand Three Hundred Forty Five";
        res = numberToWords.numberToWords(Input);
        assert(res.equals(Output));

        Input = 1234567;
        Output = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
        res = numberToWords.numberToWords(Input);
        assert(res.equals(Output));

        Input = 1234567891;
        Output = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        res = numberToWords.numberToWords(Input);
        assert(res.equals(Output));
    }
}