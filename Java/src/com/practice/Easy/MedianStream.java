package com.practice.Easy;

import java.util.*;

public class MedianStream {
    int[] findMedian(int[] arr) {
        int[] res = new int[arr.length];

        // Time: O(nlogn) <-- O(1) + O(5logn) at worse heap 3 insert/2 delete <-- do this n times
        // Space: O(m) <-- O(m + m) where m is at most n elements

        Queue<Integer> nq = new PriorityQueue<>(Collections.reverseOrder()); // store smaller half
        Queue<Integer> xq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; ++i) { // O(n) where n is arr length
            // insert new element to nq, and xq takes the ripple
            nq.add(arr[i]);
            xq.add(nq.poll());

            // re-balancing by pulling back one element from xq
            if (nq.size() < xq.size()) {
                nq.add(xq.poll());
            }

            if (nq.size() != xq.size()) {
                if (nq.size() > xq.size()) {
                    res[i] = nq.peek();
                } else {
                    res[i] = xq.peek();
                }
            } else {
                res[i] = (nq.peek() + xq.peek()) / 2;
            }
        }
        return res;
    }
}
