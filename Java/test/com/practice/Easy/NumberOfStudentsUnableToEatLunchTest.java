package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfStudentsUnableToEatLunchTest {

    @Test
    public void countStudents() {
        NumberOfStudentsUnableToEatLunch sol = new NumberOfStudentsUnableToEatLunch();
        int[] students, sandwitches;
        int actual, expected;

        students = new int[]{1,1,0,0};
        sandwitches = new int[]{0,1,0,1};
        expected = 0;
        actual = sol.countStudents(students, sandwitches);
        Assert.assertEquals(expected, actual);


        students = new int[]{1,1,1,0,0,1};
        sandwitches = new int[]{1,0,0,0,1,1};
        expected = 3;
        actual = sol.countStudents(students, sandwitches);
        Assert.assertEquals(expected, actual);

    }
}