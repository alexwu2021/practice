package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringsDifferByOneTest {

    @Test
    public void differByOne() {
        StringsDifferByOne sol = new StringsDifferByOne();
        String[] dicts;
        boolean expected, actual;

        dicts = new String[]{"abc","dfe","abf"};
        actual = sol.differByOne(dicts);
        expected = true;
        Assert.assertEquals(expected, actual);
    }
}