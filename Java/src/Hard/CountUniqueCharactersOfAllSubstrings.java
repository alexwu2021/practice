package Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  Let's define a function countUniqueChars(s) that returns the number of unique characters on s.
 *
 * For example if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear
 * only once in s, therefore countUniqueChars(s) = 5.
 *
 * Given a string s, return the sum of countUniqueChars(t) where t is a substring of s.
 *
 * Notice that some substrings can be repeated so in this case you have to count the repeated ones too.
 */
public class CountUniqueCharactersOfAllSubstrings {

    private static final int MOD = (int)1e9 + 7;

    public int uniqueLetterString(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] prev = new int[n], next = new int[n], last = new int[26];
        Arrays.fill(prev, -1); // prev occurrence is not there initially
        Arrays.fill(next, n); // next occurrence is not there initially
        Arrays.fill(last, -1);  // last occurrence of char is not there initially

        int res = 0;

        for (int i = 0; i < n; ++i) {
            int idx = s.charAt(i) - 'A'; // get relative index of current character
            prev[i] = last[idx]; // update prev occurrence to last one
            if (last[idx] >= 0) next[last[idx]] = i;  // if there was previous occurrence then update its next occurrence
            last[idx] = i;  // this would be latest occurrence for current char so update
        }
        for (int i = 0; i < n; ++i) {
            // for each char in string, check how many substrings can be formed where this is unique char
            // - can choose from left and right, all combinations is length from left times length from right
            res = (res + (i - prev[i]) * (next[i]-i)) % MOD;
        }
        return res;
    }

    /**
     * from meng789987
     *
     *Let dp[i] is sum of unique char in all substring ending at i, then the answer is sum(dp[i]), i=[0..n-1].
     * It's not difficult to get the recursive formula:
     * dp[i] = dp[i-1] + (i - first_from_i(s[i])) - (first_from_i(s[i]) - second_from_i(s[i]))
     *
     * Take the below example:
     *
     * BBBBBBBBBBBBBBBBBOABCDOABCOABC
     *                  ^    ^   ^
     *                  s    f   i
     *
     * dp[i] = dp[i-1] + (i-f) - (f-s)
     * When extending s[i] to all substrings ending with s[i-1], there are (i-f) more unique char s[i],
     * and (f-s) less unique char because of duplicate of s[i].
     *
     *
     * @param s
     * @return
     */
    public int uniqueLetterString_dp(String s) {
        final int MOD = 1000000007;
        int n = s.length();
        int ans = 0, dp = 0;
        int[] near = new int[26], far = new int[26];
        for(int i=0; i<n; ++i){
            dp++;

            int ci = s.charAt(i) - 'A';
            dp = dp + i - near[ci] * 2 + far[ci];
            ans = (ans + dp ) % MOD;

            far[ci] = near[ci];
            near[ci] = i + 1;
        }
        return ans;
    }

    // note: it is a wrong to split the string s into {[0] [1, n-1]}, {[0, n-2][n-1]}


}
