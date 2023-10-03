package com.practice.Hard;

public class LongestValidParentheses {

    public int lvp(String s){
        int maxlen = 0;
        int dp[] = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int pre = i - dp[i - 1] - 1;
                // check the pre is in range and s[pre] equals '('
                if (pre >= 0 && s.charAt(pre) == '(') {
                    // remember to plus dp[pre - 1]
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }

        return maxlen;
    }


    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];

        for (int i = 1; i < s.length(); ++i) {

            // we care only about the ')' chars
            if (s.charAt(i) == ')') {

                // concerning the immediate left

                // if it is a '(' that would make a pair
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }

                else
                {
                    // unless 前边的合法序列的前边是左括号
                    int pre = i - dp[i - 1] -1;
                    if (pre >= 0 && s.charAt(pre) == '(') {
                        int complement = 0;
                        if(pre >= 1) {
                            complement = dp[pre -1 ];
                        }
                        dp[i] = dp[i - 1] + 2 + complement;
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
