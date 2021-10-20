package Medium;

/**
 *
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray_simplified(int[] A) {
        int n = A.length, mx = A[0], mn = A[n-1];
        int s = 0, e = 0;
        for ( int i = 1; i < n; ++i ) {
            mx = Math.max(mx, A[i]);
            mn = Math.min(mn, A[n - 1 - i]);
            if (A[i] < mx) s = i;
            if (A[n-1-i] > mn)  e = n - 1 - i;
        }
        if(s > e) return s - e + 1;
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
