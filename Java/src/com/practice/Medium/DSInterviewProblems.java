package com.practice.Medium;

import java.util.List;

/** Cardea interview problems for data scientists and/or data engineers
 */
public class DSInterviewProblems {

    /**
     * find the sum of the elements of the contiguous subarray having the smallest(minimum) sum.
     *
     * Examples:
     *
     * Input : int[] nums = {3, -4, 2, -3, -1, 7, -5}
     * Output : -6
     * Subarray is {-4, 2, -3, -1} = -6
     *
     * Input : int[] nums = {2, 6, 8, 1, 4}
     * Output : 1
     *
     * @param num: given integer array
     * @return sum of the elements of the contiguous subarray
     */
    int problem1_SumOfMinimalContiguousSubArray(int[] num){
        return 0;
    }


    /**
     * Is it possible to sum up two or more than two elements or all to equal to target, assuming
     * an element should be at most one time?
     * Examples:
     *
     * Input : int[] nums = {2, 3}, int target = 5
     * Output : true
     *
     * Input : int[] nums = {2, 4}, int target = 5
     * Output : false
     * @param nums
     * @param target
     * @return
     *
     */
    boolean problem2_a_canSumUpToTarget(int[] nums, int target){ return false;}


    /**
     * Let us build an expression out of nums by adding one of the symbols '+' and '-' before each integer
     * in nums and then concatenate all the integers, for example, if nums = [2, 1], adding a '+' before 2
     * and a '-' before 1 and concatenating them, we will have the expression "+2-1". The problem is how many
     * unique ways can we do that?
     *
     * Example 1:
     * Input: nums = [1,1,1,1,1], target = 3
     * Output: 5
     * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     *
     * Example 2:
     * Input: nums = [1], target = 1
     * Output: 1
     * @param nums
     * @param target
     * @return
     */
    int Problem2_b_findNumberOfWaysOfSummingUpToTarget(int[] nums, int target){ return 0;}

    /**
     * Can you put all the resulting expressions from Problem2_b_findNumberOfWaysOfSummingUpToTarget
     * into a list and return? That is, can we do backtracking?
     *
     *  Example 1:
     *  Input: nums = [1,1,1,1,1], target = 3
     *  Output: ["-1+1+1+1+1", "+1-1+1+1+1", "+1+1-1+1+1", "+1+1+1-1+1", "+1+1+1+1-1"]
     *
     *  Example 2:
     *  Input: nums = [], target = 3
     *  Output: [""]
     *
     * @param nums
     * @param target
     * @return return list of string, each of them is the expression we build from nums by the rules aforementioned
     */
    List<String> problem2_c_FindOutWaysOfSummingUpToTarget(int[] nums, int target){ return null;}

}
