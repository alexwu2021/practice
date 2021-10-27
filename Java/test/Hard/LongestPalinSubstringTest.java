package Hard;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalinSubstringTest {
    @Test
    public void GetLongestPalinString() {

        LongestPalinSubstring sol = new LongestPalinSubstring();
        String s, actual, actual_2, expected;

        s = "acct";
        expected = "cc";
        actual = sol.longestPalindrome(s);
        Assert.assertEquals(expected, actual);
        actual_2 = sol.longestPalinSubstringDp(s);
        Assert.assertEquals(expected, actual_2);

        s = "babad";
        expected = "bab";
        actual = sol.longestPalindrome(s);
        Assert.assertEquals(expected, actual);
        actual_2 = sol.longestPalinSubstringDp(s);
        Assert.assertEquals(expected, actual_2);




        s = "a";
        expected = "a";
        actual = sol.longestPalindrome(s);
        Assert.assertEquals(expected, actual);
        actual_2 = sol.longestPalinSubstringDp(s);
        Assert.assertEquals(expected, actual_2);



        s = "ababad";
        expected = "ababa";
        actual = sol.longestPalindrome(s);
        Assert.assertEquals(expected, actual);
        actual_2 = sol.longestPalinSubstringDp(s);
        Assert.assertEquals(expected, actual_2);


    }

}