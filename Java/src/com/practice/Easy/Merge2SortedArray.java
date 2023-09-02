package com.practice.Easy;

public class Merge2SortedArray {
    /**
     *
     * use the nums1 in the reverse order
     *
     *
     *
     * @param nums1 having length of m + n
     * @param m stands for the number of non-zero values in nums1
     * @param nums2
     * @param n the actual size of nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }
    }
}
