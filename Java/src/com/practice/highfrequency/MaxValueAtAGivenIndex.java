package com.practice.highfrequency;

/**
 * 1802. Maximum Value at a Given Index in a Bounded Array
 *
 *
 *
 *
 */
public class MaxValueAtAGivenIndex {

    /**
     * TODO: need study the calc of sum
     *
     * @param givenIndex
     * @param valAtIndex
     * @param n
     * @return
     */
    private long getSum(int givenIndex, int valAtIndex, int n) {
        long sum = 0; // must use long

        // On givenIndex's left:
        // If valAtIndex > givenIndex, there are givenIndex + 1 numbers in the arithmetic sequence:
        // [value - givenIndex, ..., value - 1, value].
        // Otherwise, there are value numbers in the arithmetic sequence:
        // [1, 2, ..., valAtIndex - 1, valAtIndex], plus a sequence of length (givenIndex - valAtIndex + 1) of 1s.
        if (valAtIndex > givenIndex) {
            sum += (long) (valAtIndex + valAtIndex - givenIndex) * (givenIndex + 1) / 2;
        } else {
            sum += (long) (valAtIndex + 1) * valAtIndex / 2 + givenIndex - valAtIndex + 1;
        }

        // On givenIndex's right:
        // If valAtIndex >= n - givenIndex, there are n - givenIndex numbers in the arithmetic sequence:
        // [valAtIndex, valAtIndex - 1, ..., value - n + 1 + givenIndex].
        // Otherwise, there are value numbers in the arithmetic sequence:
        // [valAtIndex, valAtIndex - 1, ..., 1], plus a sequence of length (n - givenIndex - valAtIndex) of 1s.
        if (valAtIndex >= n - givenIndex) {
            sum += (long) (valAtIndex + valAtIndex - n + 1 + givenIndex) * (n - givenIndex) / 2;
        } else {
            sum += (long) (valAtIndex + 1) * valAtIndex / 2 + n - givenIndex - valAtIndex;
        }

        return sum - valAtIndex;
    }

    public int maxValue(int n, int givenIndex, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (getSum(givenIndex, mid, n) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
