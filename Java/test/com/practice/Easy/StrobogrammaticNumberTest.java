package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrobogrammaticNumberTest {

    @Test
    public void isStrobogrammatic() {
        StrobogrammaticNumber sol = new StrobogrammaticNumber();

        String num;
        boolean actual, expected;

        num = "69";
        actual = sol.isStrobogrammatic(num);
        expected = true;
        Assert.assertEquals(expected, actual);

        num = "88";
        actual = sol.isStrobogrammatic(num);
        expected = true;
        Assert.assertEquals(expected, actual);

        num = "1";
        actual = sol.isStrobogrammatic(num);
        expected = true;
        Assert.assertEquals(expected, actual);

        num = "692";
        actual = sol.isStrobogrammatic(num);
        expected = false;
        Assert.assertEquals(expected, actual);


        num = "9556";
        actual = sol.isStrobogrammatic(num);
        expected = false;
        Assert.assertEquals(expected, actual);


        num = "90806";
        actual = sol.isStrobogrammatic(num);
        expected = true;
        Assert.assertEquals(expected, actual);

        num = "101";
        actual = sol.isStrobogrammatic(num);
        expected = true;
        Assert.assertEquals(expected, actual);

    }
}