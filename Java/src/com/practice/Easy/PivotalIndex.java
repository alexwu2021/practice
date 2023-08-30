package com.practice.Easy;

/**
 * 724. Find Pivot Index
 * Easy
 *
 * 2402
 *
 * 341
 *
 * Add to List
 *
 * Share
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum
 * of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 * This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class PivotalIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int n: nums) sum += n;

        int i= 0;
        int leftSum = 0, rightSum;
        while(i < nums.length){
            rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
            i++;
        }
        return -1;
    }
}
