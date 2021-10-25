package Easy;

/**
 * 338. Counting Bits
 * Easy
 *
 * 4989
 *
 * 246
 *
 * Add to List
 *
 * Share
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * Constraints:
 *
 * 0 <= n <= 105
 *
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=1; i<=n; ++i)
            ans[i] = numberOfOnes(i);
        return ans;
    }
    private int numberOfOnes(int i){
        int max = Integer.numberOfLeadingZeros(0);
        int count = 0;
        while(Integer.numberOfLeadingZeros(i) != max){
            if( (i ^ (i-1)) == 1) count++;
            i = i >>1;
        }
        return count;
    }

    /**
     * Explaination.
     * Take number X for example, 10011001.
     * Divide it in 2 parts:
     * <1>the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " )
     * <2>the other digits ( the number of 1, which is " f[i >> 1] ", equivalent to " f[i/2] " )
     * @param n
     * @return
     */
    public int[] countBits_dp(int n) {
        int[] ans = new int[n+1];
        for(int i=1; i<=n; ++i)
            ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }


}
