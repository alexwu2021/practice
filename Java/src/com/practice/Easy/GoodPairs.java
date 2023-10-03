package com.practice.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i<nums.length; ++i){
            mp.put(nums[i],
                    mp.computeIfAbsent(nums[i], x->new ArrayList<>())).add(i);
        }
        int ans = 0;
        for(Map.Entry<Integer, List<Integer>> s: mp.entrySet()){
            if (s.getValue().size() > 1){
                int len = s.getValue().size();
                ans += len * (len - 1) /2;
            }
        }
        return ans;
    }

}
