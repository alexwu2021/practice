package Medium;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaxProdSubArray {

    /** inspried by shridhish
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;
        int ans = Integer.MIN_VALUE;
        int i = 0, prod = 1;
        while(i < nums.length){
            prod = prod * nums[i];
            ans = Math.max(prod, ans);
            if(prod == 0) { prod = 1; }
            i++;
        }

        // the reverse way is needed because of the distribution of possible zeros
        i--; prod = 1;
        while( i >= 0){
            prod = prod * nums[i];
            ans = Math.max(prod, ans);
            if(prod == 0) { prod = 1; }
            i--;
        }
        return ans;
    }
}
