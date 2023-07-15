package Easy;

public class MinSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int s = 0;
        int sm = 0; // the sum of a sliding window, dynamically adjusted

        int ans = Integer.MAX_VALUE;

        for(int e = 0; e < nums.length; ++e){
            sm += nums[e];
            while(sm >= target){
                ans = Math.min(ans, e - s + 1);
                sm -= nums[s]; // drop the earliest element
                s++;
            }
        }

        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}
