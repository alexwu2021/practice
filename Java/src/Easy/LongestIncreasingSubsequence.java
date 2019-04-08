package Easy;

public class LongestIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length <= 0) return 0; // error checking is always needed
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; ++i){
            if(i == 0 || nums[i] > nums[i-1]){
                count++;
                max = Math.max(max, count);
            } else {
                count = 1; //pay attention to this, must be 1
            }
        }
        return max;
    }
}
