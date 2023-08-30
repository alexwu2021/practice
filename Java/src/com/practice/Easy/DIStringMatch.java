package com.practice.Easy;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 *
 * Example 1:
 *
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: "DDI"
 * Output: [3,2,0,1]
 */
public class DIStringMatch {

    public int[] diStringMatch_SmartieWay(String S) {
        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; ++i)
            res[i] = S.charAt(i) == 'I' ? left++ : right--;
        res[n] = left;
        return res;
    }

    /** passed oj
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        if(S == null || S.length() <= 0) return null;
        int n = S.length();
        int[] ans = new int[n + 1];
        int l = 0, r = n;  // pay attention to the initialization r = n
        for(int i = 0; i < n; ++i){
            if(S.charAt(i) == 'I') ans[i] = l++;
            else ans[i] = r--;
        }
        ans[n] = l;
        return ans;
    }
}
