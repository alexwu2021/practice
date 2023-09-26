package com.practice.Easy.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length <= 0)
            return new int[0]; // this requirement is insane

        int len = nums.length;
        int[] ans = new int[len - k + 1];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, Collections.reverseOrder());

        int j = 0, r = 0;
        while(j < k) q.offer(nums[j++]);
        ans[r++] = q.peek();

        for(; j < nums.length; ++j){
            int n = nums[j];
            if(n > q.peek()){
                q.clear();
                q.offer(n);
                ans[r++] = n;
                continue;
            }

            if(q.size() >= k) q.remove(nums[j - k]); // the oldest must go
            q.offer(n);

            ans[r++] = q.peek();
        }
        return ans;
    }
}
