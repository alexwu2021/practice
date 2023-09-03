package com.practice.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #46
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * #78
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * #90. Subsets II
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Permutation {

    // ---------------------------------------- subsets --------------------------------------
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), nums);
        return ans;
    }

    void dfs(List<List<Integer>> ans, List<Integer>curr, int[] nums){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; ++i){
            if(curr.contains(nums[i])) continue; // note: we can't allow dupes

            curr.add(nums[i]);
            dfs(ans, curr, nums);
            curr.remove(curr.size()-1);
        }

    }

    // ---------------------------------------- subsets --------------------------------------
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, new ArrayList<>(), nums, 0);
        return list;
    }

    void dfs(List<List<Integer>> ans, List<Integer>curr, int[] nums, int start){
        ans.add(new ArrayList<>(curr)); // note1: new
        for(int i= start; i<nums.length; ++i){ // note2: from start
            curr.add(nums[i]);
            dfs(ans, curr, nums, i+1); // note3: use (i + 1) not (start + 1)
            curr.remove(curr.size()-1);
        }
    }


    // ---------------------------------------- subsets 2--------------------------------------

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(nums);

        dfs_ss2(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    void dfs_ss2(List<List<Integer>>ans, List<Integer>curr, int[] nums, int start){
        ans.add(new ArrayList<>(curr));

        for(int i= start; i<nums.length; ++i){
            if(i > start && nums[i] == nums[i -1]) { // note: only compare the two adjacent elements in nums,
                // we should not get curr into the comparison
                continue;
            }

            curr.add(nums[i]);
            dfs_ss2(ans, curr, nums,  i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    // ---------------------------------------- permutation 2--------------------------------------

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        dfs_perm2(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    void dfs_perm2(List<List<Integer>> ans, List<Integer>curr, int[] nums, boolean[] used){
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; ++i){
            if(used[i] ) continue;
            if((i > 0) && (nums[i] == nums[i-1]) && (!used[i-1])) continue;
            used[i] = true;
            curr.add(nums[i]);
            dfs_perm2(ans, curr, nums, used);
            curr.remove(curr.size() -1);
            used[i] =false;
        }
    }
}
