package com.practice.Easy;

import java.util.*;

public class FindMissingRanges {

    public List<String> findMissingRanges_stillBuggy(int[] nums, int lower, int upper) {
        List<String>ans = new ArrayList<>();
        if(nums == null) return ans;

        if(nums.length <= 0){
            if(lower == upper){
                ans.add("" + lower);
            }else{
                ans.add(lower+"->"+upper);
            }
            return ans;
        }
        if(nums.length == 1){
            if(lower == upper && lower== nums[0])
                return ans;
            if (nums[0]-lower ==upper-nums[0]){
                ans.add("" + lower);
                ans.add("" + upper);
                return ans;
            }

            if(nums[0] == lower){
                if(upper == nums[0]+1){
                    ans.add("" + upper);
                    return ans;
                }else{
                    ans.add((nums[0]+1)+ "->" + upper);
                    return ans;
                }
            }

            if(nums[0] == upper){
                if(lower == nums[0]-1){
                    ans.add("" + lower);
                    return ans;
                }else{
                    ans.add((lower)+ "->" + (nums[0]-1));
                    return ans;
                }
            }


        }

        List<int[]>lst = new ArrayList<>();
        if(nums[0] > lower + 1)
            lst.add(new int[]{lower, nums[0]});
        for(int i=0; i<nums.length-1; ++i) {
            if (nums[i + 1] > nums[i] + 1)
                lst.add(new int[]{nums[i], nums[i + 1]});
        }
        if(nums[nums.length-1] < upper -1)
            lst.add(new int[]{nums[nums.length-1], upper});

        for(int[] pair: lst){
            int start = pair[0], end = pair[1];
            if(start > lower)
                start++;
            if(end < upper)
                end--;
            if(start == end)
                ans.add(start+"");
            else
                ans.add(start + "->" + end);
        }
        return ans;
    }


    /**
     * from mcopy
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int n : nums) {
            if(n > lower) res.add(expr(lower, n, false));
            if(n == upper) return res;
            lower = n + 1;
        }
        res.add(expr(lower, upper, true));
        return res;
    }

    private String expr(int lo, int hi, boolean isHiInclusive){
        String ret = "" + lo;
        if(isHiInclusive){
            if(hi >lo) ret += "->" + hi;
            return ret;
        }
        if(hi > (lo+ 1)) ret += "->" + ( hi - 1 );
        return ret;
    }

}
