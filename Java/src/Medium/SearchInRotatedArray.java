package Medium;

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
}
