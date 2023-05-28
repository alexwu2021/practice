package Medium;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer k. You can partition the array into at most k non-empty adjacent subarrays.
 * The score of a partition is the sum of the averages of each subarray.
 *
 * Note that the partition must use every integer in nums, and that the score is not necessarily an integer.
 *
 * Return the maximum score you can achieve of all the possible partitions.
 * Answers within 10-6 of the actual answer will be accepted.
 */
public class LargestSumOfAverages {

    /**
     * nums = new int []{4,1,7,5,6,2,3};
     *         k = 4;
     *         expected = 18.16667;
     * @param nums
     * @param k
     * @return
     */
    public double largestSumOfAverages(int[] nums, int k) {
        double ret = 0;


        return ret;
    }
    public double largestSumOfAverages_nonadjacent(int[] nums, int k) {
        double ret = 0;
        Arrays.sort(nums);

        double temp = 0;
        int i;
        for(i=0; i<k; ++i){
            temp += nums[i];
        }
        double base = temp / k;
        ret += base;

        for(int j=nums.length-1; j>=k;){
            if(nums[j] >= base){
                ret += (double)nums[j];
                j--;
                continue;
            }else{
                double current = nums[j];
                int count = 1;
                while(current < base && j >= k && count < k){
                    current = (current * count + nums[j]) / (count + 1);
                    count++;

                }
                ret += current;
                j -= count;
            }

        }
        return ret;
    }
}
