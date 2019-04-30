package Hard;

import java.util.*;

/**
 * Given a blacklist B containing unique integers from [0, N), write a function to return a uniform
 * random integer from [0, N) which is NOT in B.
 *
 * Optimize it such that it minimizes the call to system’s Math.random().
 *
 * Note:
 *
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N) does NOT include N. See interval notation.
 * Example 1:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * Output: [null,0,0,0]
 */
public class RandomPickWithBlacklist {

    int M;
    Random rand;
    Map<Integer, Integer> mp;

    /**
     *  copied from cafebaby
     *
     *  his comment: Suppose N=10, blacklist=[3, 5, 8, 9], re-map 3 and 5 to 7 and 6.
     *
     * @param N
     * @param blacklist
     */
    public RandomPickWithBlacklist(int N, int[] blacklist) {
        mp = new HashMap();
        for (int b : blacklist) // O(B)
            mp.put(b, -1);
        M = N - mp.size();

        for (int b : blacklist) { // O(B)
            if (b < M) { // re-mapping
                while (mp.containsKey(N - 1))
                    N--;
                mp.put(b, N - 1);
                N--;
            }
        }

        rand = new Random();
    }

    public int pick() {
        int p = rand.nextInt(M);
        if (mp.containsKey(p))
            return mp.get(p);
        return p;
    }

}

//---------------------------------------------

/**
 * from lattes
 *
 * t's already told b is from [0,N) so no need to check b.
 * And we only need to map b from [0,M) to non-b from [M,N)
 * and could use a set to store b from [M,N), no need to store all b in a map.
 * based on your idea, could this be better?
 */
class OtherSolution{
    Map<Integer,Integer> map;
    Set<Integer> blackSet;
    Random random;
    int range;
    public OtherSolution(int N, int[] blacklist) {
        // B black num, N total, N-B valid
        // map black num [0,N-B] to valid num  [N-B,N]
        // [0,N-B)[N-B,N)
        this.blackSet = new HashSet<>();
        this.map = new HashMap<>();
        this.random = new Random();
        int B = blacklist.length;
        // save black num after N-B
        for(int num : blacklist){
            if(num >= N-B)
                blackSet.add(num);
        }
        int val = N - B;
        // map black num before N-B
        for(int num : blacklist){
            if(num < N - B){
                while(blackSet.contains(val))
                    val ++;
                map.put(num,val++);// notice ++
            }
        }
        this.range = N - B;
    }

    public int pick() {
        int key = this.random.nextInt(range);
        // if contains in black map, return val
        // otherwise valid, return directly
        return map.getOrDefault(key,key);
    }
}