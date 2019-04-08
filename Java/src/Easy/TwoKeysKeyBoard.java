package Easy;

public class TwoKeysKeyBoard {


    /** passed oj
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int[]dp = new int[n+1];
        dp[1] = 0; //corner case: no need to do any operation
        for(int i=2; i < n+1; ++i){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j < i; ++j){
                if(i % j != 0) continue;

                //we have no idea when we are able to do the final copy all
                //once copy all applies, we pay the cost of dp[j]
                //and the number of times of doing so: i/j
                dp[i] = Math.min(dp[i], dp[j] + i / j);
            }
        }
        return dp[n];
    }


}
