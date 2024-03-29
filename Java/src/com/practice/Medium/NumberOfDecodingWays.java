package com.practice.Medium;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class NumberOfDecodingWays {

    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int [n + 1];
        dp[0] = 1;
        if(s.charAt(0) != '0') dp[1] = 1;

        for(int i = 2; i <= n; ++i){

            // at least we can transcribe the value from the previous one
            // unless it is a zero
            if(s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            // standing on i, the only thing that might have missed is
            // the path going from i - 2 to i with a single step
            // we must compensate it for it, that is, add that ways up
            int temp = Integer.parseInt(s.substring(i - 2, i));
            if(temp <= 26 && temp >= 10) { // temp >= 10 must be honored
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
