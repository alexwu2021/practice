package Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountSubstringsWithOnlyOneDistinctLetterTest {

    @Test
    public void countLetters() {
        CountSubstringsWithOnlyOneDistinctLetter sol = new CountSubstringsWithOnlyOneDistinctLetter();
        String s;
        int expected, actual;

        s = "aaaba";
        expected = 8;
        actual = sol.countLetters(s);
        Assert.assertEquals(expected, actual);

        s = "aaaaaaaaaa";
        expected = 55;
        actual = sol.countLetters(s);
        Assert.assertEquals(expected, actual);

    }
}