package Hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalinSubstringDpTest {
    private LongestPalinSubstringDp sol;

    @Before
    public void setUp() throws Exception {
        sol = new LongestPalinSubstringDp();
    }



    private String s1 = "acct";

    @Test
    public void GetLongestPalinString() {

        int actual = sol.longestPalinSubstring(this.s1);
        String expected = "cc";

        Assert.assertEquals(expected, actual);
    }
}