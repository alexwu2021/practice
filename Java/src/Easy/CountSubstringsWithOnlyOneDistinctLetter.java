package Easy;

/**
 * Given a string s, return the number of substrings that have only one distinct letter.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaaba"
 * Output: 8
 * Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
 * "aaa" occurs 1 time.
 * "aa" occurs 2 times.
 * "a" occurs 4 times.
 * "b" occurs 1 time.
 * So the answer is 1 + 2 + 4 + 1 = 8.
 * Example 2:
 *
 * Input: s = "aaaaaaaaaa"
 * Output: 55
 *
 *
 * Constraints:
 */
public class CountSubstringsWithOnlyOneDistinctLetter {

    public int countLetters(String s) {
        int ans = s.length();
        char[] ca = s.toCharArray();
        int i=0, n = ca.length, j;
        while(i < n){
            j = i+ 1;
            while(j < n && ca[j] == ca[i]) { j++; }
            int diff = j - i;
            if(diff > 1) ans += diff * (diff-1)/2;
            i = j;
        }
        return ans;
    }


}
