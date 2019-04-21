package Medium;

public class MaxSumSubSequence {
    int findMaxSumSubSequence(int[] nums){
        int n = nums.length;
        int max = -9999;
        int [] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; ++i){
            dp[i] = Math.max(dp[i-1], nums[i-1]);
            if(nums[i-1] * -1 > dp[i])
                dp[i] = 0;
            if(dp[i-1] + nums[i-1] > dp[i])
                dp[i] = dp[i-1] + nums[i-1];

            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

}
