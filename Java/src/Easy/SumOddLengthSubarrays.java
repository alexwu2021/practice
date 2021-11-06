package Easy;

/**
 *   * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 *      * A subarray is a contiguous subsequence of the array.
 *      * Return the sum of all odd-length subarrays of arr.
 */
public class SumOddLengthSubarrays {





    /** O(N), idea originally from i_am_the_senate, implementation from prashant404
     *
     *
     *
     *
     *
     * Q1: How many times does a particular element a[i] contribute to the final sum?
     * A1: The count of all odd-sized sized subarrays that include this element a[i]
     *
     * Q2: How do you compute 'A1'?
     * A2: A subarray is odd-sized if both its start and end indices are even OR both are odd (example: start 4 to end 8 is a 5 sized subsized subarray). For any element a[i], we keep separate count of odd and even numbered indices to the left and right of it - the ones to the left would be starts of the subarrays and the ones to the right would be the ends. For every oddStart on the left, any oddStop to the right could be a valid odd-sized subarray. So, there would be oddStarts * oddStops number of subarrays of this form (i.e start and stop at odd indices). Similarly, we also have evenStarts * evenStops.
     *
     * Q3: Any implementation details?
     * A3: We dont really need to recompute oddStops, oddStarts, evenStops, evenStarts from scratch for every index - we use information about i itself to update these in preparation for i+1
     *
     * class Solution {
     *     public int sumOddLengthSubarrays(int[] arr) {
     *         int n = arr.length, ans = 0;
     *         int oddStops = n/2, evenStops = (n-1)/2+1, oddStarts = 0, evenStarts = 1;
     *         for(int i=0; i<n; ++i) {
     *             ans += (oddStops*oddStarts + evenStops*evenStarts)*arr[i];
     *             if((i&1) == 0) {
     *                 ++oddStarts;
     *                 --evenStops;
     *             } else {
     *                 ++evenStarts;
     *                 --oddStops;
     *             }
     *         }
     *         return ans;
     *     }
     * }
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays3(int[] arr) {
        int n = arr.length, sum = 0;
        int evenStops = (n & 1) == 0 ? n /2 : n/ 2 + 1;
        int evenStarts = 1;
        int oddStarts = 0;
        int oddStops = n / 2;
        for (int i = 0; i < n; ++i) {
            sum += ((oddStops * oddStarts) + (evenStops * evenStarts)) * arr[i];
            if ((i & 1) == 0) {
                oddStarts++;
                evenStops--;
            } else {
                evenStarts++;
                oddStops--;
            }
        }
        return sum;
    }


    /** O(N^2), from prashant404
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays2(int[] arr) {
        int total = 0;

        for (int windowSize = 1; windowSize <= arr.length; windowSize += 2) {
            // sum up all the elements in the first window, W1
            int windowSum = 0;
            for (int i = 0; i < windowSize; i++)
                windowSum += arr[i];
            total += windowSum;

            // slide W1 one element at a time.
            // remove (subtract) the first element from the W1 and insert (add) the last element of the slided W1 into the previous sum.
            for (int i = 1; i + windowSize <= arr.length; i++) {
                windowSum = windowSum - arr[i - 1] + arr[i + windowSize - 1];
                total += windowSum;
            }
        }
        return total;
    }

    /**
     * O(N^3)
     *
     * better style, from prashant404
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays1(int[] arr) {
        int total = 0;

        for (int window = 1; window <= arr.length; window += 2)
            for (int i = 0; i + window <= arr.length; i++)
                for (int j = i; j < i + window; j++)
                    total += arr[j];
        return total;
    }


    /** my original, O(N^3)
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays0(int[] arr) {
        int k = 1, ans = 0, n = arr.length;
        while(k <= n){
            for(int i=0; i<n; i++){
                for(int j=i; i+k <= n && j<i+k; ++j)
                    ans += arr[j];
            }
            k += 2;
        }
        return ans;
    }

}
