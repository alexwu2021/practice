package com.practice.Easy;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 *
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 *
 * Example 3:
 *
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */

public class SmallerNumbersThanCurrent {

    /** radix sort, O(n)
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] buck = new int[101];
        for(int i=0; i<nums.length; ++i)  // freq counter
            buck[nums[i]] +=1;
        for(int j=1; j<= 100; ++j) // prefix sum
            buck[j] += buck[j-1];

        for(int k=0; k< nums.length; ++k) {
            int pos = nums[k];
            nums[k] = pos==0 ? 0 : buck[pos-1];
        }
        return nums;
    }

    public int[] smallerNumbersThanCurrent_NSquare(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i <nums.length; ++i){
            int count = 0;
            for(int j = 0; j < nums.length; ++j){
                if(i == j) continue;
                if(nums[j] < nums[i])
                    count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}