package com.practice.CommonUtils;

import java.util.Arrays;

public class TwoDimensionObjectCompare {

    public static boolean equals(final int[][] arr1, final int[][] arr2) {

        if (arr1 == null) return (arr2 == null);
        if (arr2 == null) return false;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!Arrays.equals(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
