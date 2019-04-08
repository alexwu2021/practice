package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinMove2Test {

    @Test
    public void minMoves2() {
        MinMove2 minMove2 = new MinMove2();
        int[] nums = new int[]{1};
        int res = minMove2.minMove2(nums);
        assert(res == 0);


        nums = new int[]{16, 12, 3, 5, 7};
        res = minMove2.minMove2(nums);
        assert(res == 20);


        nums = new int[]{16, 12, 3, 5, 7, 1};
        res = minMove2.minMove2(nums);
        assert(res == 26);
    }
}