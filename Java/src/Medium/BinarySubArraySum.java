package Medium;

/**
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 *
 * Note:
 *
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 */
public class BinarySubArraySum {

    /**
     *  a generic prefix sum solution, from lee215
     * @param nums
     * @param sum
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int sum ) {
        int res = 0;

        // count[i] records how many start-from-index-zero (prefix) sub array that sums to i.
        int count[] = new int[nums.length + 1]; // this is good for writing the logic
        count[0] = 1; // and this is just a good example

        int psum = 0;
        for (int n : nums) {
            psum += n;
            if (psum >= sum ){
                // let j be the index where we last saw count[psum - sum]
                // let i be the index for n in nums, where j < i
                // count[psum - sum] reveals how many ways we can count towards psum-sum from 0 to j inclusively
                // and we know the presum from j to i (not including j but including i) is exactly the given sum
                // therefore, we have count[psum-sum] * 1 way to reach the sum
                // where 1 stands for the known and the only way of summing up number from j to i, where we have no other choices
                res += count[psum - sum]; // from  j = psum -sum,
            }
            count[psum]++;
        }
        return res;
    }
}
