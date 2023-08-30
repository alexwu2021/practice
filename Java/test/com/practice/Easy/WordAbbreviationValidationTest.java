package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordAbbreviationValidationTest {

    @Test
    public void validWordAbbreviation() {
        WordAbbreviationValidation sol = new WordAbbreviationValidation();
        String word, abbr;
        boolean actual, expected;


        word = "internationalization";
        abbr = "i12iz4n";
        expected =  true;
        actual = sol.validWordAbbreviation(word, abbr);
        Assert.assertTrue(actual == expected);


        word = "apple";
        abbr = "a2e";
        expected =  false;
        actual = sol.validWordAbbreviation(word, abbr);
        Assert.assertTrue(actual == expected);



    }
}