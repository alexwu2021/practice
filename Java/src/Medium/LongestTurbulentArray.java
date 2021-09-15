package Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
 *
 * A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 *
 * More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
 *
 * For i <= k < j:
 * arr[k] > arr[k + 1] when k is odd, and
 * arr[k] < arr[k + 1] when k is even.
 * Or, for i <= k < j:
 * arr[k] > arr[k + 1] when k is even, and
 * arr[k] < arr[k + 1] when k is odd.
 *
 *
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 4 * 104
 * 0 <= arr[i] <= 109
 */
public class LongestTurbulentArray {

    /**
     * passed oj, speed beat by 92% mem beat by 27%
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        if(arr == null || arr.length <= 0)
            return 0;
        if(arr.length == 1)
            return 1;

        if(arr.length == 2) {
            if (arr[1] == arr[0])
                return 1;
            return 2;
        }

        int ans = 0;
        int n = arr.length;
        int[]dp = new int[n]; // recording the count running to and including i, note: not the overall max count
        dp[0] = 1;
        if(arr[1] == arr[0]) {
            dp[1] = 1;
            ans = Math.max(ans, 1);
        }
        else{
            dp[1] = 2;
            ans = Math.max(ans, 2);
        }

        for(int i=2; i<n; ++i){
            dp[i] = dp[i-1];
            int prev = arr[i-1] - arr[i-2];
            int curr = arr[i] - arr[i-1];

            if((prev >  0 && curr < 0) || (prev <0 && curr > 0)){
                dp[i] += 1;
                ans = Math.max(ans, dp[i]);
            }else{
                dp[i] = 2;
            }
        }
        return ans;
    }
}
