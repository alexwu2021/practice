package com.practice.Design;

import org.junit.Test;

public class NumberOfRecentCallsTest {

    @Test
    public void ping() {

        NumberOfRecentCalls numberOfRecentCalls = new NumberOfRecentCalls();

        int actual, expected, t;

        t = 1;
        actual = numberOfRecentCalls.ping(t);
        expected = 1;
        assert (actual == expected);


        t = 100;
        actual = numberOfRecentCalls.ping(t);
        expected = 2;
        assert (actual == expected);


        t = 3001;
        actual = numberOfRecentCalls.ping(t);
        expected = 3;
        assert (actual == expected);

        t = 3002;
        actual = numberOfRecentCalls.ping(t);
        expected = 3;
        assert (actual == expected);


    }
}