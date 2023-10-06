package com.practice.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;

public class StickProblemRevised {

    /**
     * @param S: the array of integer
     * @param target: the number to make
     * @return
     *  return the minimal number of elements used from S to make the target number n
     *  return -1 if there is no way to make the target number n
     */
    public int findMinNumOfSticksToMakeTheNumber(int[] S, int target){
        int n = S.length;

         // dp[i][j]: stores the minimal number of sticks used in this range[0...i] for the purpose of making a number of value i
        long[][] dp = new long[n + 1][target + 1]; // to handle overflow
        Arrays.fill(dp[0], Integer.MAX_VALUE);

        for (int r = 1; r <= n; ++r) {
            for(int k = 1; k <= target; ++k) {
                // dp[r-1][k] vs. dp[r][k - S[r-1]] + 1
                dp[r][k] = dp[r - 1][k]; // cope from the previous row
                if (S[r - 1] <= k) {
                    dp[r][k] = Math.min(dp[r][k], dp[r][k - S[r - 1]] + 1);     // we can use the current element, so increment by 1 from where we jump from
                }
            }
        }

        return dp[n][target]  >= Integer.MAX_VALUE ? -1 : (int)dp[n][target];

    }


    /**
     * @param sticks
     * @param num_to_make
     * @return the minimum number of sticks to make up the num_to_make
     */
    public int findMinNumOfSticksToMakeTheNumber_recursive(int [] sticks, int num_to_make){
        int res = dfs(sticks,sticks.length, new ArrayList<>(), num_to_make);
        if (res < Integer.MAX_VALUE)
            return res;
        return -1;
    }

    int dfs(int[] sticks, int idx, List<Integer> curr, int remaining){
        // good base case
        if(remaining == 0)
            return curr.size();

        // bad base cases
        if (remaining < 0 || idx <= 0)
            return Integer.MAX_VALUE;


        // skip the current number referred by idx in sticks
        int do_not_use = dfs(sticks,idx - 1, curr, remaining);

        // use the current number referred by idx in sticks
        curr.add(sticks[idx - 1]);
        int use = dfs(sticks, idx, curr, remaining - sticks[idx - 1]);
        curr.remove(curr.size() - 1); // tailspin

        return Math.min(do_not_use, use);
    }

}
