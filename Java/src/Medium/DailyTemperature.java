package Medium;

import java.util.*;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you
 * how many days you would have to wait until a warmer temperature. If there is no future day for which
 * this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be
 * [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in
 * the range [30, 100].
 */
public class DailyTemperature {

    /**
     * Runtime: 70 ms, faster than 28.91% of Java online submissions for Daily Temperatures.
     * Memory Usage: 44.4 MB, less than 34.55% of Java online submissions for Daily Temperatures.
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int [T.length];

        // mapping element in T to the most recent
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = T.length - 1; i >= 0; --i) {
            ans[i] = Integer.MAX_VALUE;

            // dynamically update the ans array
            for (Integer key : map.keySet()) {
                if (T[i] < key)
                    ans[i] = Math.min(ans[i], map.get(key) - i);
            }

            // this is the key part: record the index of the element just evaluated T[i]
            // because by now only the element at i is relevant for possible future checking
            // since this works backwards, it is possible that T[i] has been mapped to j where j > i
            map.put(T[i], i);

            if (ans[i] == Integer.MAX_VALUE) { ans[i] = 0;}
        }
        return ans;
    }


//    /** it will hit TLE
//     * @param T
//     * @return
//     */
//    public int[] dailyTemperatures_NeverDoThis(int[] T) {
//        if(T == null || T.length <= 0) return T;
//
//        int n = T.length;
//        int[] ans = new int[n];
//        Arrays.fill(ans, Integer.MAX_VALUE);
//        ans[n - 1] = 0;
//
//        Map<Integer, Set<Integer>> mp = new HashMap<>();
//        for (int idx = n - 1; idx >= 0; idx--) {
//            mp.computeIfAbsent(T[idx], x -> new TreeSet<>()).add(idx);
//        }
//
//        int[] temp = T.clone();
//        Arrays.sort(temp);
//
//        for (int i = 0; i < n; ++i) {
//            for (int index : mp.get(temp[i])) {
//                if(index >=  n - 1 ) continue;
//                boolean found = false;
//                idxloop:
//                for (int j = index + 1; j < n; ++j) {
//                    for (int index2 : mp.get(T[j])) {
//                        if (T[index2] > T[index] && index2 > index) {
//                            ans[index] = index2 - index;
//                            found = true;
//                            break idxloop;
//                        }
//                    }
//                }
//                if(!found) ans[index] = 0;
//            }
//        }
//        return ans;
//    }
}
