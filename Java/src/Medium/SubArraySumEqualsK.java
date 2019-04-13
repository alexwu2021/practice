package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        if(nums == null || nums.length <= 0) return res;

        Map<Integer, Integer> sum2NumOfPresum = new HashMap<>(); // sum by now to the number of all presum seen
        sum2NumOfPresum.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum2NumOfPresum.containsKey(sum - k)) {
                // (sum[i, j] == k)   =>  ( sum[0, j] - sum[0, i - 1] == k)
                res += sum2NumOfPresum.get(sum - k);
            }
            sum2NumOfPresum.put(sum, sum2NumOfPresum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
