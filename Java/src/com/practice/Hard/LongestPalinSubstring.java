package com.practice.Hard;

public class LongestPalinSubstring {

    /** still buggie
     * @param s
     * @return
     */
    public String longestPalinSubstringDp(String s)
    {
        if (s==null || s.length() <= 1) return s;
        int n = s.length();
        int mxlen = 1;
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; ++i) dp[i][i] = true;

        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                mxlen = 2;
            }
        }
        String ret = "";
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (k > mxlen) {
                        mxlen = k;
                        ret = s.substring(i, i + k);
                    }
                }
            }
        }
        return ret;
    }

    private int lo, maxLen;
    public String longestPalindrome(String s) {
        if (s==null || s.length() <= 1) return s;
        for (int i = 0; i < s.length()-1; ++i) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
