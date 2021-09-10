package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticSlices2Test {

    @Test
    public void numberOfArithmeticSlices_dp() {
        ArithmeticSlices2 arithmeticSlices2 = new ArithmeticSlices2();
        int[] nums = new int[]{2,4,6,8,10};
        int expected = 7;
        int actual = arithmeticSlices2.numberOfArithmeticSlices_dp(nums);
        Assert.assertTrue(expected == actual);

        nums = new int[] {0,2};
        expected = 0;
        actual = arithmeticSlices2.numberOfArithmeticSlices_dp(nums);
        Assert.assertTrue(expected == actual);

        nums = new int[] {0,2, 4};
        expected = 1;
        actual = arithmeticSlices2.numberOfArithmeticSlices_dp(nums);
        Assert.assertTrue(expected == actual);

        nums = new int[] {0,2, 0, 4};
        expected = 1;
        actual = arithmeticSlices2.numberOfArithmeticSlices_dp(nums);
        Assert.assertTrue(expected == actual);

        nums = new int[] {2, 0, 4};
        expected = 0;
        actual = arithmeticSlices2.numberOfArithmeticSlices_dp(nums);
        Assert.assertTrue(expected == actual);


        nums = new int[] {0,2000000000,-294967296};
        expected = 0;
        actual = arithmeticSlices2.numberOfArithmeticSlices_dp(nums);
        Assert.assertTrue(expected == actual);

    }
}