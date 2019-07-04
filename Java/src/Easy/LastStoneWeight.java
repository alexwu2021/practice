package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {

    public int lastStoneWeight_plain(int[] stones) {
         List<Integer> lst = new ArrayList<>();
         Arrays.sort(stones);
         for(int s : stones) lst.add(s);

         while(lst.size() >= 2){
             int last = lst.get(lst.size() - 1);
             int seclast = lst.get(lst.size() - 2);
             lst.remove(lst.size() - 1);
             lst.remove(lst.size() - 1);

             int diff = Math.abs(last - seclast);
             if(diff > 0 ){
                 int i = 0;
                 while (i < lst.size() && lst.get(i) < diff){
                     i++;
                 }
                 lst.add(i, diff);
             }
         }
         return lst.size() == 0 ? 0 : lst.get(0);
    }

    public int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int a : A)
            pq.offer(a);
        for (int i = 0; i < A.length - 1; ++i)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
}
