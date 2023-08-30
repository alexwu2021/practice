package com.practice.Easy;

public class FindMinInRotatedSortedArray {
    public int findMinBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0, right = n - 1;
        while (right > left) {
            int m = left + (right - left) / 2;
            if(m == left) return Math.min(nums[left], nums[right]);

            if (nums[m] < nums[left] && nums[m] < nums[right]) {
                right = m;
            } else if (nums[m] > nums[left] && nums[m] > nums[right]) {
                left = m;
            } else if (nums[m] > nums[left] && nums[m] < nums[left]) {
                left = m;
            } else {
                right = m;
            }
        }
        return nums[left];
    }


    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            if(nums[left] < nums[right])
                break;
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
