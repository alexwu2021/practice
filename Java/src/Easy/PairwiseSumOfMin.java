package Easy;

import java.util.Arrays;

public class PairwiseSumOfMin {


    /** passed oj, the idea is to sum the min of the pairs at 1st, 3rd, 5th, ....
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length %2 != 0)
            return Integer.MAX_VALUE;
        Arrays.sort(nums);

        int n = nums.length;
        int ret = 0;
        for(int i=0; i<n; i += 2){
            ret += nums[i];
        }
        return ret;
    }
}
