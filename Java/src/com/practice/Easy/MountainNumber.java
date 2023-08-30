package com.practice.Easy;

public class MountainNumber {

    public int peakIndexInMountainArray(int[] A) {
        if(A == null) return -1;

        int i = 1;
        int n = A.length;
        if (n < 3) return -1;

        while(i < n && A[i] > A[i-1]){
            i++;
        }

        if (i < n && A[i-1] > A[i])
            return i-1;

        return -1;

    }

    public int peakIndexInMountainArray_BinarySearch(int[] A) {
        if (A == null) return -1;
        int l = 0, r = A.length - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (A[mid] < A[mid + 1]) l = mid;
            else if (A[mid - 1] > A[mid]) r = mid;
            else return mid;
        }
        return 0;
    }
}
