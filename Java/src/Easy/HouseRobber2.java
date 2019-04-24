package Easy;

public class HouseRobber2 {

    /** the only added on constraint is that the houses form a circle
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];

        // this section: not rob n-1
        int rob = 0, norob = 0, i;
        for(i = 0; i< nums.length-1; ++i){
            int robCurr = nums[i] + norob;
            norob = Math.max(norob, rob);
            rob = robCurr;
        }
        int leftie = Math.max(rob, norob);


        // this section: not rob 0
        rob = 0;
        norob = 0;
        for(i = 1; i< nums.length; ++i){
            int robCurr = nums[i] + norob;
            norob = Math.max(norob, rob);
            rob = robCurr;
        }

        // since there are only these two cases
        // that is, unable to rob 0 and n -1 at the same time
        // qed
        int rightie = Math.max(rob, norob);
        return Math.max(leftie, rightie);
    }
}
