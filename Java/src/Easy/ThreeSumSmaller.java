package Easy;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example:
 *
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 *              [-2,0,1]
 *              [-2,0,3]
 */
public class ThreeSumSmaller {


    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for 3Sum Smaller.
     * Memory Usage: 40.6 MB, less than 8.19% of Java online submissions for 3Sum Smaller
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        int tripletCounts = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 2; ++i) {
            int j = i + 1, k = n - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] < target) {
                    tripletCounts += k - j; // any element in this range are admissible
                    j++;
                } else {
                    k--;
                }
            }
        }
        return tripletCounts;
    }
}
