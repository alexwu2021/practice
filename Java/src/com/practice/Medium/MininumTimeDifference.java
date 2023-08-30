package com.practice.Medium;

import java.util.List;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 */
public class MininumTimeDifference {

    /** oj passed, inspred by jdrogin
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        boolean[] axis = new boolean[24 * 60];
        for(String t: timePoints) {
            int hour = 10 * (t.charAt(0) - '0') + (t.charAt(1) - '0');
            int minute = 10 * (t.charAt(3) - '0') + (t.charAt(4) - '0');
            int index = hour * 60 + minute;
            if (axis[index]) return 0; // duplicate
            axis[index] = true;
        }

        int min = axis.length, curr = axis.length;
        for (int i = 0; i < axis.length; ++i) {
            if (axis[i]) {
                if (curr < min) { min = curr;} // only enter here on the second axis[i] == true and so on
                curr = 1;
            } else {
                curr++;
            }
        }

        // now check wrap around time diff
        int dist = 1; // distance
        int first = 0;
        while (!axis[first]) { first++; dist++; }

        int last = axis.length - 1;
        while (!axis[last]) { last--; dist++; }

        if (dist < min) min = dist;

        return min;
    }
}
