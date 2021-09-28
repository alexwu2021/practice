package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanSumTest {

    @Test
    public void canSum() {
        CanSum sol = new CanSum();
        int[] nums;
        int target;
        boolean actual, expected;

//        nums = new int[]{2, 4};
//        target = 6;
//        expected = true;
//        actual = sol.canSum(target, nums);
//        Assert.assertEquals(expected, actual);

//        nums = new int[]{2, 5};
//        target = 6;
//        expected = false;
//        actual = sol.canSum(target, nums);
//        Assert.assertEquals(expected, actual);

//        nums = new int[]{9, 5, 3, 4};
//        target = 7;
//        expected = true;
//        actual = sol.canSum(target, nums);
//        Assert.assertEquals(expected, actual);

//
//        nums = new int[]{9, 5, 3, 4};
//        target = 12;
//        expected = true;
//        actual = sol.canSum(target, nums);
//        Assert.assertEquals(expected, actual);

        nums = new int[]{9, 5, 3, 4};
        target = 11;
        expected = false;
        actual = sol.canSum(target, nums);
        Assert.assertEquals(expected, actual);
    }
}