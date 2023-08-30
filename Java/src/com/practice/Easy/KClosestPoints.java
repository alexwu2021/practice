package com.practice.Easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

    /** passed oj
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        //this line must be in reverse order such that the pq is a minqueue
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((b, a) -> (a[0] * a[0] + a[1] * a[1])
                -  (b[0] * b[0] + b[1] * b[1]));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) pq.poll(); //this line has to be there
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K; ++i) res[i] =  pq.poll();
        return res;
    }


    /** also passed oj, and here I can learn the usage of Comparator.comparing and copyOfRange
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest_otherway(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }

    /** borrowed from frimish
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest_borrowed(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
}
