package com.practice.Easy;

public class RemoveDupsInSortedArray {

    /** passed oj with
     * Runtime: 1 ms, faster than 99.98% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 40.3 MB, less than 86.33% of Java online submissions for Remove Duplicates from Sorted Array.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates_Ugly(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;
        if(nums.length == 1) return 1;
        if(nums.length == 2 && nums[0] == nums[1]) return 1;

        int i = 0, j = 1;
        while(j < nums.length){
            while(j < nums.length && nums[i] == nums[j]){
                j++;
            }
            if(j == nums.length) break;
            i++;
            if(j > i) nums[i] = nums[j];
            else j++;
        }

        if(nums[i] != nums[j -1]){
            i++;
            nums[i] = nums[j-1];
        }
        return i + 1;
    }


    /** from StefanPochmann
     *
     * Runtime: 1 ms, faster than 99.98% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 39.6 MB, less than 93.57% of Java online submissions for Remove Duplicates from Sorted Array.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
