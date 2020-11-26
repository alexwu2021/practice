package amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem2Test {

    @Test
    public void dosth2() {

        Problem2 problem2 = new Problem2();

        int actual, expected;

        actual = problem2.dosth2();
        expected = 2;
        Assert.assertEquals(expected, actual);
    }
}