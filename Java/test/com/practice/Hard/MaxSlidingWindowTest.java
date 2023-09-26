package com.practice.Hard;


import com.practice.Easy.Hard.MaxSlidingWindow;
import org.junit.Test;

public class MaxSlidingWindowTest {

    @Test
    public void maxSlidingWindow() {

        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int [] nums;
        int [] res;
        int k, i;

        nums = new int[]{1,3,-1,-3,5,3,6,7};
        k = 3;
        res = maxSlidingWindow.maxSlidingWindow(nums, k);
        i = 0;
        assert (res[i++] == 3 && res[i++] ==3 && res[i++] ==5 && res[i++] ==5 && res[i++] ==6 && res[i++] ==7);
    }
}