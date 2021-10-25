package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestStringChainTest {

    @Test
    public void longestStrChain() {
        LongestStringChain sol = new LongestStringChain();
        String[] words;
        int actual, expected;

        words = new String[]{"ab", "abc"};
        expected = 2;
        actual = sol.longestStrChain(words);
        Assert.assertEquals(expected, actual);



        words = new String[]{"a","b","ba","bca","bda","bdca"};
        expected = 4;
        actual = sol.longestStrChain(words);
        Assert.assertEquals(expected, actual);


        words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        expected = 5;
        actual = sol.longestStrChain(words);
        Assert.assertEquals(expected, actual);

        words = new String[]{"a","ab","ac","bd","abc","abd","abdd"};
        expected = 4;
        actual = sol.longestStrChain(words);
        Assert.assertEquals(expected, actual);



        words = new String[]{"abcd","dbqca"};
        expected = 1;
        actual = sol.longestStrChain(words);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isPre() {
        LongestStringChain sol = new LongestStringChain();
        String[] words;
        boolean actual, expected;



        words = new String[]{"ab", "abc"};
        actual = sol.isPre(words, 0, 1);
        expected = true;
        Assert.assertEquals(expected, actual);


        words = new String[]{"abc", "abc"};
        actual = sol.isPre(words, 0, 1);
        expected = false;
        Assert.assertEquals(expected, actual);

        words = new String[]{"ad", "abc"};
        actual = sol.isPre(words, 0, 1);
        expected = false;
        Assert.assertEquals(expected, actual);
    }
}