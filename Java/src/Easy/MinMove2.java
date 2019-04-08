package Easy;

import java.util.Arrays;

public class MinMove2 {

    public int minMove2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length >> 1];
        return Arrays.stream(nums).map(i -> Math.abs(median - i)).sum();
    }





    //bad attempts
//    public int minMoves2(int[] nums) {
//        if(nums.length <= 1)
//            return 0;
//
//        int sm = 0;
//        for(int n: nums){ sm += n;}
//
//        int avg = sm / nums.length;
//        int[] tests = new int[]{avg-1, avg, avg+1};
//        return getMoves(nums, tests);
//    }
//
//    private int getMoves(int[] nums, int[] tests){
//        int res = Integer.MAX_VALUE;
//        for(int target: tests){
//            int moves = 0;
//            for(int n: nums){
//                moves += Math.abs(target - n);
//            }
//            res = Math.min(res, moves);
//        }
//        return res;
//    }
}
