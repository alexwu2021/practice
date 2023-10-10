package com.practice.Medium;

public class CountK {
    public int count_k(int[] arr, int target) {
        int left = binarySearch(arr, target, true);
        if (left < 0) return 0;
        int right = binarySearch(arr, target, false);
        return right - left + 1;
    }

    private int binarySearch(int[] arr, int target, boolean leftmost) {
        int lo = 0;
        int hi = arr.length - 1;
        int idx = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1; // avoid overflow. same as (lo + hi) / 2

            if (target > arr[mid]) {
                lo = mid + 1;
            } else if (target < arr[mid]) {
                hi = mid - 1;
            } else {
                idx = mid;
                if (leftmost) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return idx;
    }
}
