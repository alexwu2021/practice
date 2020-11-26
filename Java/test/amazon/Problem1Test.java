package amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem1Test {

    @Test
    public void dosth() {
        Problem1 problem1 = new Problem1();

        int actual, expected;

        actual = problem1.dosth();
        expected = 1;
        Assert.assertEquals(expected, actual);
    }
}