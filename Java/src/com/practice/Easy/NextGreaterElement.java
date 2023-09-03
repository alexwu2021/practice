package com.practice.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer>mp = new HashMap<>();
        Stack<Integer>stack = new Stack<>();
        for(int n: nums2){
            while(stack.size() > 0 && stack.peek() <= n){ // both < and <= work in this case
                mp.put(stack.pop(), n);
            }
            stack.push(n);
        }

        int[] ans = new int[nums1.length];
        int i = 0;
        for(int nm: nums1){
            ans[i++] = mp.getOrDefault(nm, -1);
        }
        return ans;
    }

    public int[] nextGreaterElement_nsquare(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int i = 0;

        for(int n: nums1){
            int j = 0, val = -1;
            for(; j<nums2.length; ++j){
                if(nums2[j] == n){
                    break;
                }
            }

            if(j < nums2.length){
                while(j < nums2.length && nums2[j] <= n){
                    j++;
                }
                if(j < nums2.length){
                    val = nums2[j];
                }
            }
            ans[i++] = val;
        }
        return ans;
    }
}
