package com.practice.Easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaxNumber {

    /** passed oj, easy to follow solution
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                pq.offer(num);
                set.add(num);
                if (pq.size() > 3)
                    set.remove(pq.poll());

            }
        }

        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
