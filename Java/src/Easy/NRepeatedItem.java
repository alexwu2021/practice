package Easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedItem {

    /**
     *  In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
     *
     *  Return the element repeated N times.
     *
     *  passed OJ
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        Set<Integer> seen = new HashSet<>();
        for (int a: A) {
            if (seen.contains(a))
                return a;
            seen.add(a);
        }
        return -1;
    }
}
