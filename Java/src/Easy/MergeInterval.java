package Easy;

import CommonTypes.Interval;

import java.util.*;

public class MergeInterval {

    /** 168 / 168 test cases passed.
     Status: Accepted
     Runtime: 5 ms
     Memory Usage: 41.2 MB
     apparently better
     * @param intervals
     * @return
     */
    public int[][] merge_sort(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i< intervals.length; ++i) {
            if(intervals[i][0] <= end){ //pay attention to <=
                end = Math.max(end, intervals[i][1]);
            } else{
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }

    /** 168 / 168 test cases passed.
     Status: Accepted
     Runtime: 17 ms
     Memory Usage: 44.2 MB

     * @param intervals
     * @return
     */
    public int[][] merge_no_sort(int[][] intervals) {
        List<int[]>res = new ArrayList<>();
        Queue<int[]> q = new PriorityQueue<int[]>((a, b) ->(a[0] - b[0]));
        for(int[] intv : intervals) q.offer(intv);
        while(!q.isEmpty()){
            int[] front = q.poll();
            if(q.isEmpty()){
                res.add(front);
                break;
            }
            int[] top = q.peek();
            if(front[1] >= top[0]){
                top = q.poll();
                q.offer(new int[]{Math.min(front[0], top[0]), Math.max(front[1], top[1])});
                continue;
            }else{
                res.add(front);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
