package com.practice.Hard;

public class FindMedianInTwoSortedArray {

    /** passed oj
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) return findMedianSortedArrays(B, A);

        int mn = 0, mx = m, halfLength = (m + n + 1) / 2;
        int maxLeft, minRight;
        boolean isOdd = (m + n) % 2 == 1;
        while (mn <= mx) {
            int iShorter = (mn + mx) / 2; // cut index in the shorter string
            int iLonger = halfLength - iShorter; // cut index in the longer string
            if (iShorter < mx &&  A[iShorter] < B[iLonger - 1]) {
                mn = iShorter + 1; // iShorter is too small
                continue;
            }
            if (iShorter > mn && A[iShorter - 1] > B[iLonger]) {
                mx = iShorter - 1; // iShorter is too big
                continue;
            }

            // the cut by (iShorter, iLonger) is perfect
            // what is the perfect situation?
            // A[iShorter + 1] >= B[iLonger -1] && A[iShorter -1] <= B[iLonger + 1]

            if (iShorter == 0) { maxLeft = B[iLonger - 1]; }
            else if (iLonger == 0) { maxLeft = A[iShorter - 1]; }
            else { maxLeft = Math.max(A[iShorter-1], B[iLonger - 1]); }

            if (isOdd) return maxLeft;

            if (iShorter == m) { minRight = B[iLonger]; }
            else if (iLonger == n) { minRight = A[iShorter]; }
            else { minRight = Math.min(A[iShorter], B[iLonger]); }

            return (maxLeft + minRight) / 2.0;
        }
        return 0;
    }
}
