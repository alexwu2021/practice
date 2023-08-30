package com.practice.Easy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1167. Minimum Cost to Connect Sticks
 * Medium
 *
 * 798
 *
 * 141
 *
 * Add to List
 *
 * Share
 * You have some number of sticks with positive integer lengths. These lengths are given
 * as an array sticks, where sticks[i] is the length of the ith stick.
 *
 * You can connect any two sticks of lengths x and y into one stick by paying a cost of
 * x + y. You must connect all the sticks until there is only one stick remaining.
 *
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 *
 * gist: start with the shortest pairs
 */
public class MinimumCostOConnectingSticks {
    public int connectSticks(int[] s) {
        int ans = 0;
        Queue<Integer> q = new PriorityQueue<>();
        for(int n : s) q.offer(n);
        while(q.size() >= 2){
            int a = q.poll(), b = q.poll();
            int temp = a + b;
            ans += temp;
            q.offer(temp);
        }
        return ans;
    }
}
