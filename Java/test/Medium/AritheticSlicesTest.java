package Medium;

import org.junit.Assert;
import org.junit.Test;

public class AritheticSlicesTest {

    @Test
    public void numberOfArithmeticSlices() {
        ArithmeticSlices aritheticSlices = new ArithmeticSlices();
        int[] nums = new int[]{1,2,3,8,9,10};
        int expected = 2;
        int actual = aritheticSlices.numberOfArithmeticSlices(nums);
        Assert.assertTrue(actual == expected);
    }
}