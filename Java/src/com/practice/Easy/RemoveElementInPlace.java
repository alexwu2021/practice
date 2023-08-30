package com.practice.Easy;

public class RemoveElementInPlace {


    /**
     * in place remove the given val from the given int array, but may change the the order of the elements
     * @param nums
     * @param val the target to remove
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--; // make the program run faster
            } else {
                i++;
            }
        }
        return n;
    }
}
