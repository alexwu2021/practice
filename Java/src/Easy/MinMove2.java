package Easy;

import java.util.Arrays;

public class MinMove2 {

    public int minMove2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length >> 1];
        return Arrays.stream(nums).map(i -> Math.abs(median - i)).sum();
    }
}
