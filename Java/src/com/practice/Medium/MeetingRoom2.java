package com.practice.Medium;



import com.practice.DataStructure.CommonTypes.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {

    /**
     *  passed oj
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * find the minimum number of conference rooms required.

     Example 1:

     Input: [[0, 30],[5, 10],[15, 20]]
     Output: 2
     Example 2:

     Input: [[7,10],[2,4]]
     Output: 1
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b)-> { return a.start - b.start; });
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, (a, b)-> { return a.end - b.end; });
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = pq.poll();
            // oh, no conflicts, record this by just relaxing the curr.edn
            if (intervals[i].start >= curr.end) {
                curr.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }
            pq.offer(curr);
        }
        return pq.size();
    }
}
