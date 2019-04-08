package Easy;

public class PaintHouse {
    /** passed oj
     *  borrowed from yao9208
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length <= 0) return 0;
        int n = costs.length;
        for(int i = 1; i < n; ++i){
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]); // it is the accumulated number
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(Math.min(costs[n-1][0], costs[n-1][1]), costs[n-1][2]);
    }

    /** borrowed from ggplay
     * @param costs
     * @return
     */
    public int minCost_NoChangeToSource(int[][] costs) {
        if(costs == null || costs.length < 1 || costs[0].length < 1) return 0;

        int n = costs.length;
        int[][] dp = new int[n][3];
        for(int c = 0; c < 3; c++) dp[0][c] = costs[0][c];

        // dp[i][c] = dp[i-1][C != c] + cost[i][C == c].
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }

}
