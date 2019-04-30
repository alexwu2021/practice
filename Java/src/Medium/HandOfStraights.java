package Medium;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class HandOfStraights {

    /** borrowed from lee215
     * O(MlogM + MW), where M is the number of different cards.
     * @param hand
     * @param W
     * @return
     */
    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 0 || hand == null || hand.length <= 0) return false;
        if (W > hand.length || hand.length % W != 0) return false;

        Map<Integer, Integer> mp = new TreeMap<>();
        for (int i : hand) mp.put(i, mp.getOrDefault(i, 0) + 1);

        Queue<Integer> q = new LinkedList<>();
        int lastChecked = -1, opened = 0;

        // note: mp is a tree mp, so we are looping from the smallest
        for (int i : mp.keySet()) {
            if (opened > 0 && i > lastChecked + 1 || opened > mp.get(i))
                return false;
            q.add(mp.get(i) - opened);
            lastChecked = i; opened = mp.get(i);
            if (q.size() == W)
                opened -= q.remove();
        }
        return opened == 0;
    }
}
