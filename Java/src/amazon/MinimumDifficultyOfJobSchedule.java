package amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.
 *
 * Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 * Example 2:
 *
 * Input: jobDifficulty = [9,9,9], d = 4
 * Output: -1
 * Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
 * Example 3:
 *
 * Input: jobDifficulty = [1,1,1], d = 3
 * Output: 3
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 * Example 4:
 *
 * Input: jobDifficulty = [7,1,7,1,7,1], d = 3
 * Output: 15
 * Example 5:
 *
 * Input: jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * Output: 843
 */
public class MinimumDifficultyOfJobSchedule {

    private Map<int[], Integer> _interval2Value = new HashMap<>();

    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d)
            return -1;
        int ret =  minDifficulty(jobDifficulty, jobDifficulty.length -1, d, 0)        ;
        return ret;
    }

    // might be a good application for dp, but did not give a try
    // dp[j] = min(dp[j-1] + [j, j], dp[j-2], [j-1, j] )
    // [1, 2, 3, 8, 9]
    // offset 3
    // d = 2

    private int getMaxDiffBetween(int[] jobDifficulty, int [] interval){
        if(_interval2Value.containsKey(interval))
            return _interval2Value.get(interval);
        int max = 0;
        for(int i = interval[0]; i<= interval[1]; ++i){
            max = Math.max(max, jobDifficulty[i]);
        }
        _interval2Value.put(interval, max);
        return max;
    }

    private int minDifficulty(int[] jobDifficulty, int offset, int d, int accumulatedDiff) {
            if(d == 1)
                return getMaxDiffBetween(jobDifficulty, new int[]{0, offset}) + accumulatedDiff;

            int absolute = offset + 1;
            int reserved = d - 1;
            int distance = absolute - reserved;

            // invariance:  offset - (offset - distance + 1) + 1 = distance
            int min = Integer.MAX_VALUE;
            for(int j = offset; j > offset - distance; --j){
                int ad = accumulatedDiff + getMaxDiffBetween(jobDifficulty, new int[]{j, offset});
                int temp = minDifficulty(jobDifficulty, j -1, d-1, ad);
                if(temp == -1){
                    return -1;
                }
                min = Math.min(min, temp);
            }
            return min;
    }
}
