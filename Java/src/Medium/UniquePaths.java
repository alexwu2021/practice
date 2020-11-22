package Medium;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        //初始化最后一列
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        //从右向左更新所有列
        for (int i = n - 2; i >= 0; i--) {
            //最后一行永远是 1，所以从倒数第 2 行开始
            //从下向上更新所有行
            for (int j = m - 2; j >= 0; j--) {
                //右边的和下边的更新当前元素
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[(n - 1)];
    }

}
