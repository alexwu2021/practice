package com.practice.Design;

import java.util.*;

/**
 * You are given several logs, where each log contains a unique ID and timestamp. Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second,
 * for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.
 *
 * Implement the LogSystem class:
 *
 * LogSystem() Initializes the LogSystem object.
 * void put(int id, string timestamp) Stores the given log (id, timestamp) in your storage system.
 * int[] retrieve(string start, string end, string granularity) Returns the IDs of the logs whose timestamps are within the range from start to end inclusive. start and end all have the same format as timestamp, and granularity means how precise the range should be (i.e. to the exact Day, Minute, etc.). For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", and granularity = "Day" means that we need to find the logs within the inclusive range from Jan. 1st 2017 to Jan. 2nd 2017, and the Hour, Minute, and Second for each log entry can be ignored.
 */
public class LogSystem {
    private static final String mn = "2000:01:01:00:00:00";;
    private static final String mx = "2017:12:31:23:59:59";
    private HashMap<String, Integer> mpGranToIndex;
    private TreeMap<String, LinkedList<Integer>> tmLogs;

    public LogSystem() {
        mpGranToIndex = new HashMap<>();
        mpGranToIndex.put("Year", 4);
        mpGranToIndex.put("Month", 7);
        mpGranToIndex.put("Day", 10);
        mpGranToIndex.put("Hour", 13);
        mpGranToIndex.put("Minute", 16);
        mpGranToIndex.put("Second", 19);
        tmLogs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        if(!tmLogs.containsKey(timestamp)) {
            tmLogs.put(timestamp, new LinkedList<>());
        }
        tmLogs.get(timestamp).add(id);
    }

    /**
     * return the IDs of the retrieved log entries
     *
     * @param s
     * @param e
     * @param gra
     * @return
     */
    public List<Integer> retrieve(String s, String e, String gra) {
        LinkedList<Integer> ans = new LinkedList<>();

        int index = mpGranToIndex.get(gra);
        String start = s.substring(0, index) + mn.substring(index), end = e.substring(0, index) + mx.substring(index);

        NavigableMap<String, LinkedList<Integer>> sub = tmLogs.subMap(start, true, end, true);

        for (Map.Entry<String, LinkedList<Integer>> entry : sub.entrySet()) {
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}