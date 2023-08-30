package com.practice.Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfDecodingWaysTest {

    @Test
    public void numDecodings() {

        NumberOfDecodingWays numberOfDecodingWays = new NumberOfDecodingWays();
        String input;
        int actual, expected;

//        input = "226";
//        expected = 3;
//
//        actual = numberOfDecodingWays.numDecodings(input);
//        assert(actual == expected);
//

        input = "22";
        expected = 2;

        actual = numberOfDecodingWays.numDecodings(input);
        assert(actual == expected);
    }
}