package com.practice.Medium;

public class SearchInRotatedArray {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     * Memory Usage: 38.3 MB, less than 89.08% of Java online submissions for Search in Rotated Sorted Array.
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int res = -1;
        if(nums == null || nums.length <= 0) return res;
        int left = 0, right = nums.length - 1;
        while (left <= right){  // this is the tricky part: we must have equal to sweep all the corner cases
            int mid = left + (right - left) / 2; // stop using left  + (right - left) >> 1
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]){
                // search the right just because target is no where in the sorted ascending left segment
                if (target > nums[mid] || target < nums[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            else if (nums[mid] <= nums[right]){
                // search the right if and only if target is in the sorted ascending right segment
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return res;
    }


    public boolean search_good_for_real_test_scenario(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while ( left <= right ) { // the equal sign!
            int mid = left + (right - left) / 2; // this should not be rewritten as (right - left) >> 1, which will lead to LTE
            if(nums[mid] == target) return true;

            // special case: nums[left] = nums[mid] = nums[right]
            if( nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }

            // below are two levels of evaluations
            //   1. target vs. nums[mid], OR
            //   2. target vs. nums[left] or target vs. nums[right]
            // we always do affect left and right in this fashion: left = mid + 1 or right = mid - 1

            // the left part is sorted
            if( nums[mid] >= nums[left] )
            {
                if(target > nums[mid] || target < nums[left]) // all we need to do is to inject this: || target < nums[left]
                    left = mid + 1;
                else
                    right = mid - 1;
                continue;
            }

            // the right part is sorted
            if(target < nums[mid] || target > nums[right]) // all we need to do is to inject this: || target > nums[right]
                right = mid - 1;
            else
                left = mid + 1;

        }
        return false;
    }
}
