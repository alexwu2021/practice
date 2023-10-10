package com.practice.Medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitScheduleTest {

    @Test
    void maxProfitSchedule() {


        int[] A = new int[]{23, 4, 5, 20};
        int[] B = new int[] {21, 1, 10,100};
        MaxProfitSchedule sol = new MaxProfitSchedule();

        String expected = "ATBB", actual;
        actual = sol.maxProfitSchedule(A, B);
        assertEquals(expected, actual);


    }
}