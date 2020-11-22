package Easy;


/**
 * given an integer array, each representing the max step one can jump. assume initially at index 0, find the minimal
 * steps to reach the last index. You can assume that you can always reach the last index
 *
 * must be solved using Greedy Algorithm since it is worded in this fashion: You can assume that you can always reach the last index
 */
public class JumpGame {

    public int jump(int[] nums) {
        int farthest = 0, prev_level_farthest = 0, level = 0;

        // there is no point to till the end index because it is the target index one wants to reach
        for (int i = 0; i < nums.length- 1; ++i){
            // i + nums[i] measures how many steps one can jump while standing on ith index
            farthest = Math.max (farthest, i + nums[i]);

            // once reaching the index that has been proclaimed that one can reach, we do the assessment
            // to see how farthest one can jump in the future moves
            // initially this condition is always met, so we will have a chance to update prev_level_farthest
            // greedy indeed, we use up all the allowable steps/distance for each jump and try to figure how fartherest
            // the next jump can reach
            if (i == prev_level_farthest) {
                if (farthest == prev_level_farthest) return -1; // unreachable
                ++level;
                prev_level_farthest = farthest;
            }
        }
        return level;
    }

    public int jump_original(int[] A) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i=0; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            if( i == e ) {
                sc++;
                e = max;
            }
        }
        return sc;
    }
//    public int jump(int[] nums) {
//        int end = 0;
//        int maxPosition = 0;
//        int steps = 0;
//        for(int i = 0; i < nums.length - 1; i++){
//            //找能跳的最远的
//            maxPosition = Math.max(maxPosition, nums[i] + i);
//            if( i == end){ //遇到边界，就更新边界，并且步数加一
//                end = maxPosition;
//                steps++;
//            }
//        }
//        return steps;
//    }
}
