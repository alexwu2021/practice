package Special.Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *  All key/value strings are lowercase.
 * All key/value strings have length in the range [1, 100]
 * The timestamps for all TimeMap.set operations are strictly increasing.
 * 1 <= timestamp <= 10^7
 * TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per test case.
 *
 */
class TimeMap {

    private Map<String,TreeMap<Integer,String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    /** Stores the key and value, along with the given timestamp.
     *
     * @param key
     * @param value
     * @param timestamp
     */
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key,new TreeMap<>());
        }
        map.get(key).put(timestamp,value);
    }

    /** Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
     If there are multiple such values, it returns the one with the largest timestamp_prev.
     If there are no values, it returns the empty string ("").
     *
     *
     * @param key
     * @param timestamp
     * @return
     */
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = map.get(key);
        if(treeMap == null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);
        if(floor == null) {
            return "";
        }
        return treeMap.get(floor);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */