package Medium;


//2501. Longest Square Streak in an Array

import java.util.*;

public class SquareStreak {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        int max = -1;
        Map<Long, int[]> mpNextPair = new HashMap<>();
        Map<Long, Integer> val2Index = new HashMap<>();
        for(int i=0; i<nums.length; ++i){
            val2Index.put((long)nums[i], i);
        }
        for(Integer num: nums){
            long sq = (long)num * num;
            if(val2Index.containsKey(sq)){
                mpNextPair.put((long)num, new int[]{(int)sq, val2Index.get(sq)});
            }
        }

        for(int i=0; i<nums.length; ++i){
            long key = nums[i];
            if(!mpNextPair.containsKey(key))
                continue;

            int[] nexPair = mpNextPair.get(key);
            max = Math.max(max, getSquareStreakLength(nums, val2Index,  nexPair[0], nexPair[1], 2));
        }
        return max;
    }

    int getSquareStreakLength(int[] nums, Map<Long, Integer>val2Index, long val, int startIndex, int len){
        if(startIndex >= nums.length -1)
            return len;

        long nextExpected = val * val;
        if(!val2Index.containsKey(nextExpected)){
            return len;
        }

        len++;
        int newIndex = val2Index.get(nextExpected);
        return getSquareStreakLength(nums, val2Index, nextExpected, newIndex, len);
    }

}
