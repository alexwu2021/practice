package Medium;

import java.util.Arrays;

/**
 * find out the distance between
 * the leftest index whose value is more than min
 * the rightest index whose value is less than max
 *
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray_simplified(int[] A) {

        System.out.println(Arrays.toString(A));
        System.out.println("length: " + A.length);
        int n = A.length, mx = A[0], mn = A[n-1];
        int s = 0, // all the rightest index whose value is less than max
                e = 0;  // all the leftest index whose value is more than min
        for ( int i = 1; i < n; ++i ) {
            System.out.println(String.format("before A[i]: %d i: %d; mx:%d; mn:%d;  s: %d; e:%d", A[i], i, mx, mn, s, e));
            mx = Math.max(mx, A[i]);
            if (A[i] < mx)
                s = i;

            mn = Math.min(mn, A[n - 1 - i]);
            if (A[n-1-i] > mn)
                e = n - 1 - i;
            System.out.println(String.format("after i: %d; mx:%d; mn:%d;  s: %d; e:%d", i, mx, mn, s, e));
        }
        if(s > e)
            return s - e + 1;
        return 0;
    }


    public int findUnsortedSubarray(int[] A) {
            int n = A.length, mn = A[n-1], mx = A[0];
            int  beg = -1, end = -2;
            for (int i=1;i<n;++i) {
                mx = Math.max(mx, A[i]);
                mn = Math.min(mn, A[n-1-i]);
                if (A[i] < mx) end = i;
                if (A[n-1-i] > mn) beg = n-1-i;
            }
            return end - beg + 1;
    }


    public int findUnsortedSubarray_mine(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int n = nums.length;
        int i=0;
        while(i  <= n-2){
            if(nums[i] <= nums[i+1])
                ++i;
            else
                break;
        }
        if(i == n-1) return 0;
        int j = n-1;
        while(j-1  >= 0){
            if(nums[j] > nums[j-1])
                --j;
            else
                break;
        }
        return (j) - (i) + 1;
    }

}
