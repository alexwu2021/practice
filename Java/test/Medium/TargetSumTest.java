package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TargetSumTest {

    @Test
    public void findTargetSumWays() {
        TargetSum sol = new TargetSum();
        int target, actual, expected;
        int actual_ref;
        int[] nums;

        nums = new int[]{1, 1, 1, 1, 1};
        target = 3;
        actual = sol.findTargetSumWays(nums, target);
        actual_ref = sol.findTargetSumWays_gracemeng(nums, target);
        expected = 5;
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(actual_ref, actual);

        nums = new int[]{11,20,19,3,25,7,30,45,8,11,35,19,29,9,49,14,22,34,12,0};
        target = 34;
        actual = sol.findTargetSumWays(nums, target);
        actual_ref = sol.findTargetSumWays_gracemeng(nums, target);
        expected = 7306;
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(actual_ref, actual);

        nums = new int[]{27,22,39,22,40,32,44,45,46,8,8,21,27,8,11,29,16,15,41,0};
        target = 10;
        actual = sol.findTargetSumWays(nums, target);
        actual_ref = sol.findTargetSumWays_gracemeng(nums, target);
        expected = 0;
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(actual_ref, actual);


    }
}