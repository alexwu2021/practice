package Easy;

import CommonTypes.Interval;

import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

    /** Given a collection of intervals, merge all overlapping intervals.
     *  passed oj
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> i1.start - i2.start);

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i< intervals.size(); ++i) {
            if(intervals.get(i).start <= end){ //pay attention to <=
                end = Math.max(end, intervals.get(i).end);
            } else{
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
}
