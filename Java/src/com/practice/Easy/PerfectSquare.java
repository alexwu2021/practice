package com.practice.Easy;

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) { // equal should be included
            // declare mid as long to prevent overflow
            long mid = (low + high) >>> 1; // unsigned right shift, essentially divided by 2 without overflow
            long midSquare = mid * mid;
            if (midSquare == num) {
                return true;
            }

            if (midSquare < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}
