package Special.DP;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 */
public class NumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        // dp[i] means the lengh of LIS ending at i
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        // cnt[i] means # LIS ending at i
        int[] cnt = new int[len];

        int ret = 0, max = 1;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (1 + dp[j] > dp[i]) {
                        count = cnt[j];
                        dp[i] = 1 + dp[j];
                    } else if (1 + dp[j] == dp[i]) {
                        count += cnt[j];
                    }
                }
            }
            cnt[i] = count;

            if (dp[i] > max) {
                ret = count;
                max = dp[i];
            } else if (dp[i] == max) {
                ret += count;
            }
        }
        return ret;
    }

    /*

    for those guys who are not quite familiar with this type of problem, please also check No.549. Binary Tree Longest Consecutive Sequence II to have a better understanding..
for each element in the array or on in the tree, they all carry three fields :
1) the maximum increasing / decreasing length ends at the current element,
2) its own value ,
3) the total number of maximum length,
and each time when we visit a element, we will use its 2) to update 1) and 3), the only difference is for array we use iteration while for tree we use recursion......
Also, for substring problem, we usually use only one for loop because for each index, we only care about the relationship between its two neighbors, while for subsequence problem, we use two for loops , because for each index, any other indexes can do something...
     */
}
