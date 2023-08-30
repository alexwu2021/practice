package com.practice.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsectiveSubsequence {

    public int longestConsecutive(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        int max = 1;
        for(int num: nums) {
            if(set.remove(num)) {
                int sum = 1;

                // expending from center to both sides
                // if there are more than 1 subsequence, then all will be covered
                int val = num;
                while(set.remove(val-1)) val--;
                sum += num - val;

                val = num;
                while(set.remove(val+1)) val++;
                sum += val - num;

                max = Math.max(max, sum);
            }
        }
        return max;
    }


    public int longestConsecutive_passed_but_undesired(int[] nums2) {
        if(nums2 == null || nums2.length <= 1) return nums2.length;
        Set<Integer>st = new HashSet<>();
        for(int n : nums2) st.add(n);

        int[] nums = new int[st.size()];
        int k = 0;
        for(int key : st) nums[k++] = key;
        Arrays.sort(nums);

        int ans = 1;
        int i = 0, j;
        while(i < nums.length){
            int a = nums[i];
            while(i < nums.length && nums[i] == a){i++;}
            if(i == nums.length){
                break;
            }
            i--;
            j = i + 1;
            while(j < nums.length && nums[j] == nums[j-1] + 1){
                j++;
            }
            ans = Math.max(ans, j - i );
            i = j;
        }
        return ans;
    }
}
