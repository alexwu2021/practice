package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 */
public class TargetSum {
    private static Map<String, Integer> memo; // key: serialized curIndex and targetSum, value: its corresponding number of ways

    public int findTargetSumWays_gracemeng(int[] nums, int S) {
        memo = new HashMap<>();
        return findTargetSumWaysRecur(nums, S, 0, S);
    }

    private static int findTargetSumWaysRecur(int[] nums, int S, int curIndex, int targetSum) {

        String curSerial= serialize(curIndex, targetSum);
        if (memo.containsKey(curSerial)) {
            return memo.get(curSerial);
        }

        if (curIndex == nums.length) {
            if (targetSum == 0) {
                return 1;
            }
            return 0;
        }

        int numWaysIfMinus = findTargetSumWaysRecur(nums, S, curIndex + 1, targetSum + nums[curIndex]); // -nums[curIndex]
        int numWaysIfAdd = findTargetSumWaysRecur(nums, S, curIndex + 1, targetSum - nums[curIndex]); // +nums[curIndex]

        int numWays =  numWaysIfMinus + numWaysIfAdd;
        memo.put(curSerial, numWays);
        return numWays;
    }

    private static String serialize(int curIndex, int targetSum) {
        return curIndex + "," + targetSum;
    }

    private Map<int[], Integer> _mp = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0, nums, 0, target);
    }

    private int helper(int val, int[] nums, int i, int target) {
        int[] key = new int[]{i, target};
        if (_mp.containsKey(key)) return _mp.get(key);
        if(i == nums.length){
            if(val == target)
                return 1;
            return 0;
        }
        int res = helper(val+nums[i], nums, i+1, target) + helper(val-nums[i], nums, i+1, target);
        _mp.put(key, res);
        return res;
    }
}
