package Easy;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    public int fib_iterative(int N) {
        if(N <= 1) return N;

        int[] fib_cache = new int[N + 1];
        fib_cache[1] = 1;

        for(int i = 2; i <= N; i++) {
            fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
        }
        return fib_cache[N];
    }


    Map<Integer, Integer> mp = new HashMap<>();

    /** mine, passed oj
     * @param N
     * @return
     */
    public int fib(int N) {
        if(N <= 1) return N;

        mp.put(1, 1);
        if(mp.containsKey(N))
            return mp.get(N);

        int res = fib(N-1) + fib(N-2);
        mp.put(N, res);
        return res;

    }
}
